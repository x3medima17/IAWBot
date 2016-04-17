import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * Created by serge on 17.04.2016.
 */

public class MessageHelper {
    public static String getAnswer(String command) throws IOException {
        //JsonElement resultJson = new JsonParser().parse(command);
        String tempUrl = URLEncoder.encode(command, "utf-8");
        String duckURL = new String("http://api.duckduckgo.com/?q=" + tempUrl + "&format=json&pretty=1");
        Request request = new Request(duckURL);
        String answer = request.response;

        return answer;
    }

//    public static String sendMessageToServer(String command) throws IOException {
//        String tempUrl = URLEncoder.encode(command, "utf-8");
//        String duckURL = new String("http://api.duckduckgo.com/?q=" + tempUrl + "&format=json&pretty=1");
//        URL url = new URL(duckURL);
//        URLConnection connection = url.openConnection();
//        InputStream response = connection.getInputStream();
//        String result = convertStreamToString(response);
//        return result;
//    }
//
//    private static String convertStreamToString(InputStream is) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        StringBuilder sb = new StringBuilder();
//
//        String line = null;
//        try {
//            while ((line = reader.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//           is.close();
//        }
//        return sb.toString();
//    }
}
