import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by dumitru on 09.04.16.
 */
public class ApiAi {
    private String token;
    private String sessionId;
    private String lang;

    private String prefix = "http://api.api.ai/api";

    ApiAi(Config config) {
        this.token = config.get("token");
        this.sessionId = config.get("sessionId");
        this.lang = config.get("lang");
    }

    ApiAi(){}

    public String getJsonByMessage(String msg) throws UnsupportedEncodingException {
        HashMap<String, String> data = new HashMap<>();
        data.put("query", msg);
        data.put("lang", lang);
        data.put("sessionId", sessionId);

        String url = String.format("%s/query", prefix);
        Request req = new Request(url);
        req.setMethod("GET");
        req.setHeader("Authorization", "Bearer "+token);
        req.setPort(80);
        req.setData(data);
        req.send();
        System.out.println(req.response);

        return req.response;
    }
}
