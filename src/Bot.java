import java.util.HashMap;

/**
 * Created by dumitru on 09.04.16.
 */
public class Bot {
    private String token;
    private String prefix = "https://api.telegram.org/bot";

    Bot(String token) {
        this.token = "212445639:AAE3OrJuCIOGwnUaOrVjv20YoT-j3i6bPio";
    }

    public String getMe() {
        String url = String.format("%s%s/getMe", prefix, token);
        Request req = new Request(url);
        req.setMethod("GET");
        req.send();
        return req.response;
    }

    public String sendMessage(String chatId, String text) {
        String url = String.format("%s%s/sendMessage",prefix,token);
        HashMap<String,String> data = new HashMap<>();
        data.put("chat_id",chatId);
        data.put("text", text);
        Request req = new Request(url);
        req.setMethod("GET");
        req.setData(data);
        req.send();
        return req.response;
    }


}
