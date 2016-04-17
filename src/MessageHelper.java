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
        //JsonElement resultJson = new JsonParser().parse(command);
        String tempUrl = URLEncoder.encode(command, "utf-8");
        String duckURL = new String("http://api.duckduckgo.com/?q=" + tempUrl + "&format=json&pretty=1");
        Request req = new Request(duckURL);
        req.setMethod();
        String answer = req.getResponse();
        return answer;
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
