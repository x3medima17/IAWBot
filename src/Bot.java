import Keyboard.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

    public String sendMessage(int chatId, String text, Keyboard reply_markup) throws UnsupportedEncodingException{
        HashMap<String, String> data = new HashMap<>();
        data.put("chat_id", Integer.toString(chatId));
        data.put("text", text);
        data.put("reply_markup", reply_markup.toString());

        String url = String.format("%s%s/sendMessage", prefix, token);
        Request req = new Request(url);
        req.setMethod("GET");
        req.setPort(80);
        req.setData(data);
        req.send();

        return req.response;
    }

    public String sendMessage(int chatId, String text) throws UnsupportedEncodingException {
        HashMap<String, String> data = new HashMap<>();
        data.put("chat_id", Integer.toString(chatId));
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

    public ArrayList<Update>  getUpdates(int offset) throws UnsupportedEncodingException {
        HashMap<String, String> data = new HashMap<>();
        data.put("offset",Integer.toString(offset));
        String url = String.format("%s%s/getUpdates", prefix, token);
        Request req = new Request(url);
        req.setData(data);
        req.setMethod("GET");
        req.setPort(80);
        req.setData(data);
        req.send();

        Response r = Response.fromJson(req.getResponse());
        JsonElement json = new JsonParser().parse(r.getResult());
        ArrayList<Update> updates = new ArrayList<>();

        for (JsonElement item : json.getAsJsonArray()) {
            Update curr =  Update.fromJson(item.toString());
            updates.add(curr);
        }
        return updates;
    }


}
