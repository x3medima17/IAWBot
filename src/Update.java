import com.google.gson.annotations.SerializedName;

/**
 * Created by dumitru on 15.04.16.
 */
public class Update {
    @SerializedName("update_id")
    private int updateId;
    private Message message;

    public Update(int updateId, Message message) {
        this.updateId = updateId;
        this.message = message;
    }

    public int getUpdateId() {
        return updateId;
    }

    public Message getMessage() {
        return message;
    }

    static Update fromJson(String raw) {
        JsonElement json = new JsonParser().parse(raw);
        int updateId = json.getAsJsonObject().get("update_id").getAsInt();
        Message message = null;

        if (json.getAsJsonObject().has("message")) {
            message = Message.fromJson(json.getAsJsonObject().get("message").toString());
        }

        return new Update(updateId, message);
    }
}
