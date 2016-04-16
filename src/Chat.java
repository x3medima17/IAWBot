import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

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

    static Chat fromJson(String raw) {
        JsonElement json = new JsonParser().parse(raw);
        int id = json.getAsJsonObject().get("id").getAsInt();
        String type = json.getAsJsonObject().get("type").toString();

        String title = null;

        if (json.getAsJsonObject().has("title")) {
            title = json.getAsJsonObject().get("title").toString();
        }
        
        return new Chat(id, type, title);
    }
}
