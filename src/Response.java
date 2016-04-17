import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.net.HttpURLConnection;

/**
 * Created by dumitru on 14.04.16.
 */
public class Response {
    private boolean ok;
    private String result;
    private String description;
    private int errno;

    Response(boolean ok, String result, String description, int errno) {
        this.ok = ok;
        this.result = result;
        this.description = description;
        this.errno = errno;
    }

    String getResult(){
        return result;
    }

    static Response fromJson(String raw) throws TelegramException {

        JsonElement json = new JsonParser().parse(raw);
        boolean ok = json.getAsJsonObject().get("ok").getAsBoolean();
        String result = "";
        String description = "";
        int errno = 0;
        if (ok) {
            result = json.getAsJsonObject().get("result").toString();
        } else {
            description = json.getAsJsonObject().get("description").toString();
            errno = json.getAsJsonObject().get("error_code").getAsInt();
            if (errno != HttpURLConnection.HTTP_OK) {
                throw new TelegramException(errno, description);
            }
        }
        return new Response(ok,result,description,errno);
    }

    public String toString() {
        return String.format("Ok: %b\nResult: %s\nDescription: %s\nerrno: %d",ok,result,description,errno);
    }
}
