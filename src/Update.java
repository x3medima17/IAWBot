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


}
