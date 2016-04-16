import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Created by dumitru on 14.04.16.
 */
public class User {
    private int id;
    private String firstName, lastName, username;

    User(int id, String firstName, String lastName, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    static User fromJson(String raw) {
        JsonElement json = new JsonParser().parse(raw);
        int id = json.getAsJsonObject().get("id").getAsInt();
        String firstName = null;
        String lastName = null;
        String username = null;

        if (json.getAsJsonObject().has("first_name")) {
            firstName = json.getAsJsonObject().get("first_name").toString();
        }

        if (json.getAsJsonObject().has("last_name")) {
            lastName = json.getAsJsonObject().get("last_name").toString();
        }

        if (json.getAsJsonObject().has("username")) {
            username = json.getAsJsonObject().get("username").toString();
        }

        return new User(id, firstName, lastName, username);
    }

    public int getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getUsername() {
        return username;
    }

}
