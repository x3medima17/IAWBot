import java.net.HttpURLConnection;
import java.io.IOException;

import java.util.HashMap;

/**
 * Created by dumitru on 07.04.16.
 */
public class Main {
    public static void main(String args[]) throws IOException {
        HashMap<String,String> data = new HashMap<>();

        data.put("fizz","buzz");
        Request req = new Request();
        req.setHost("http://requestb.in");
        req.setPath("/18xlmmy1");
        req.setPort(80);
        req.setMethod("POST ");
        req.setData(data);
        req.send();

        System.out.println(req.response);

    }
}
