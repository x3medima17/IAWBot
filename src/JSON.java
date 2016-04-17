import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Created by dumitru on 14.04.16.
 */

public class JSON {
    private String str;

    public JSON(String str) {
        this.str = str;
    }

    private static Update getUpdate(String raw) {
        JsonElement json = new JsonParser().parse(raw);
        int updateId = json.getAsJsonObject().get("update_id").getAsInt();
        Message message = null;

        if (json.getAsJsonObject().has("message")) {
            message = getMessage(json.getAsJsonObject().get("message").toString());
        }

        return new Update(updateId, message);
    }

    private static Message getMessage(String raw) {
        JsonElement json = new JsonParser().parse(raw);

        int messageId = json.getAsJsonObject().get("message_id").getAsInt();
        int date = json.getAsJsonObject().get("date").getAsInt();
        Chat chat = getChat(json.getAsJsonObject().get("chat").toString());
        User user = null;
        String text = null;

        if (json.getAsJsonObject().has("from")) {
            user = User.fromJson(json.getAsJsonObject().get("from").toString());
        }

        if (json.getAsJsonObject().has("text")) {
            text = json.getAsJsonObject().getAsJsonPrimitive("text").getAsString();
        }

        return new Message(messageId, date, user, chat, text);
    }

    private static Chat getChat(String raw) {
        JsonElement json = new JsonParser().parse(raw);
        int id = json.getAsJsonObject().get("id").getAsInt();
        String type = json.getAsJsonObject().get("type").toString();

        String title = null;

        if (json.getAsJsonObject().has("title")) {
            title = json.getAsJsonObject().get("title").toString();
        }

        return new Chat(id, type, title);
    }

    public Object parse(Class c) {
        Object parsedObject = null;
        if (c.getName().equals(Update.class.getName())) {
            parsedObject = getUpdate(str);
        } else if (c.getName().equals(Message.class.getName())) {
            parsedObject = getMessage(str);
        } else if (c.getName().equals(Chat.class.getName())) {
            parsedObject = getChat(str);
        }
        return parsedObject;
    }
}
