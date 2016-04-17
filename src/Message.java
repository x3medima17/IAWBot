import com.google.gson.annotations.SerializedName;

/**
 * Created by dumitru on 15.04.16.
 */
public class Message {
    @SerializedName("message_id")
    private int messageId;
    private int date;
    private User from;
    private Chat chat;
    private String text;


    public Message(int messageId, int date, User from, Chat chat, String text) {
        this.messageId = messageId;
        this.date = date;
        this.from = from;
        this.chat = chat;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getMessageId() {
        return messageId;
    }

    public int getDate() {
        return date;
    }

    public User getFrom() {
        return from;
    }

    public Chat getChat() {
        return chat;
    }


    static Message fromJson(String raw) {
        JsonElement json = new JsonParser().parse(raw);

        int messageId = json.getAsJsonObject().get("message_id").getAsInt();
        int date = json.getAsJsonObject().get("date").getAsInt();
        Chat chat = Chat.fromJson(json.getAsJsonObject().get("chat").toString());
        User user = null;
        String text = null;

        if (json.getAsJsonObject().has("user")) {
            user = User.fromJson(json.getAsJsonObject().get("user").toString());
        }

        if (json.getAsJsonObject().has("text")) {
            text = json.getAsJsonObject().getAsJsonPrimitive("text").getAsString();
        }


        return new Message(messageId, date, user, chat, text);
    }
}
