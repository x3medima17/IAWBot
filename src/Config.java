import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Config {
    private JsonElement jsonElement = null;

    public Config(String file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder json = new StringBuilder();
            String temp;

            while ((temp = bufferedReader.readLine()) != null) {
                json.append(temp);
            }

            jsonElement = new JsonParser().parse(json.toString());
        } catch (IOException e) {
            jsonElement = new JsonParser().parse("");
        }
    }

    public String get(String name) {
        return jsonElement.getAsJsonObject().getAsJsonPrimitive(name).getAsString();
    }
}
