import sun.misc.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by dumitru on 07.04.16.
 */
public class Request {
    public String host;
    public String path;
    public String method;
    public int port;
    public HashMap<String, String> data;
    public String response;
    public String url;

    public String getResponse() {
        return response;
    }

    Request() {
        data = new HashMap<>();
    }

    Request(String url) {
        this.url = url;
        data = new HashMap<>();
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setData(HashMap<String, String> data) {
        this.data = data;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void send() throws UnsupportedEncodingException {
        URL url;
        HttpURLConnection connection = null;

        String body = "";
        String targetURL;
        if (this.url == null)
            targetURL = String.format("%s%s", host, path);
        else
            targetURL = this.url;

        for (Map.Entry<String, String> entry : data.entrySet()) {
            String key = URLEncoder.encode(entry.getKey());
            String value = URLEncoder.encode(entry.getValue());
            body += String.format("%s=%s&", key, value);
        }
        if (body.length() > 0) {
            body = body.substring(0, body.length() - 1);
        }

        try {
            //Create connection
            url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length", "" +
                    Integer.toString(body.getBytes().length));

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(body);
            wr.flush();
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\n');

            }
            rd.close();
            this.response = response.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

    }


}
