import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Created by dumitru on 15.04.16.
 */
public class Message {
    private int messageId, date;
    private User from;
    private Chat chat;
    private String text;
    private Document document;

    public Message(int messageId, int date, User from, Chat chat, String text, Document document) {
        this.messageId = messageId;
        this.date = date;
        this.from = from;
        this.chat = chat;
        this.text = text;
        this.document = document;
    }

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

    public Document getDocument() {
        return document;
    }

    static Message fromJson(String raw) {
        JsonElement json = new JsonParser().parse(raw);

        int messageId = json.getAsJsonObject().get("message_id").getAsInt();
        int date = json.getAsJsonObject().get("date").getAsInt();
        Chat chat = Chat.fromJson(json.getAsJsonObject().get("chat").toString());
        User user = null;
        String text = null;
        Document document = null;

        if (json.getAsJsonObject().has("user")) {
            user = User.fromJson(json.getAsJsonObject().get("user").toString());
        }

        if (json.getAsJsonObject().has("text")) {
            text = json.getAsJsonObject().getAsJsonPrimitive("text").getAsString();
        }

        if(json.getAsJsonObject().has("document")){
            document = Document.fromJson(raw);
        }

        return new Message(messageId, date, user, chat, text,document);
    }
}
