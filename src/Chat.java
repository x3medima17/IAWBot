/**
 * Created by dumitru on 15.04.16.
 */
public class Chat {
    private int id;
    private String type;
    private String title;

    public Chat(int id, String type, String title) {
        this.id = id;
        this.type = type;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

}
