/**
 * Created by dumitru on 15.04.16.
 */
public class Update {
    private int update_id;
    private Message message;

    public Update(int updateId, Message message) {
        this.update_id = updateId;
        this.message = message;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public Message getMessage() {
        return message;
    }



}
