import com.google.gson.Gson;

/**
 * Created by dumitru on 14.04.16.
 */

public class JSON {
    static Gson gson = new Gson();

    public JSON() {
    }


    static Object parse(String str, Class cl) {
        return gson.fromJson(str, cl);
    }
}
