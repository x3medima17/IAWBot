/**
 * Created by dumitru on 15.04.16.
 */
public class Message {
    private int messageId, date;
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

}
