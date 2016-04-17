import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.*;
import java.io.*;
import java.util.Iterator;

/**
 * Created by serge on 17.04.2016.
 */

public class MessageHelper {
    public static String getAnswer(String command) throws IOException {
        return sendMessageToServer(command);
    }

    private static String sendMessageToServer(String command) throws IOException {
        String tempUrl = URLEncoder.encode(command, "utf-8");
        String URL = new String("http://api.duckduckgo.com/?q=" + tempUrl + "&format=json");

        Request request = new Request(URL);
        request.setMethod("GET");
        request.setPort(80);

        request.setHeaders("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        request.setHeaders("Accept", "text/html, image/gif, image/jpeg, *; q=.2, /; q=.2");
        request.setHeaders("X-Compress", "1");
        request.setHeaders("DNT", "1");
        request.setHeaders("Connection", "keep-alive");

        request.send();
        return jsonToAnswer(request.getResponse());
    }

    private static String jsonToAnswer(String json) {
        JSONParser parser = new JSONParser();
        StringBuilder sb = new StringBuilder();
        try {
            Object obj = parser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray textList = (JSONArray) jsonObject.get("RelatedTopics");
            Iterator<String> iterator = textList.iterator();
            while (iterator.hasNext()) {
                sb.append(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
