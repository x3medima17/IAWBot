import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by dumitru on 09.04.16.
 */
public class Bot {
    private String token;
    private String prefix = "https://api.telegram.org/bot";

    Bot(String token) {
        this.token = token;
    }

    Bot(){}

    public String sendMessage(String chatId, String text) throws UnsupportedEncodingException {
        HashMap<String, String> data = new HashMap<>();
        data.put("chat_id", chatId);
        data.put("text", text);

        String url = String.format("%s%s/sendMessage", prefix, token);
        Request req = new Request(url);
        req.setMethod("GET");
        req.setPort(80);
        req.setData(data);
        req.send();

        return req.response;
    }

    public String getMe() throws UnsupportedEncodingException {
        String url = String.format("%s%s/getMe", prefix, token);
        Request req = new Request(url);
        req.setMethod("GET");
        req.setPort(80);
        req.send();
        return req.response;
    }

    public String getUpdates(int offset) throws UnsupportedEncodingException {
        HashMap<String, String> data = new HashMap<>();
        String url = String.format("%s%s/getUpdates", prefix, token);
        Request req = new Request(url);
        req.setMethod("GET");
        req.setPort(80);
        req.setData(data);
        req.send();
        return req.response;
    }


}
