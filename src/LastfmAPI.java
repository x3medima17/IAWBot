import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by Solipsist-R on 17.04.2016.
 */
public class LastfmAPI {
        private static final String key="288246297cd2920f4130ec1a4192d76f";
        private static final String andkey="&api_key=288246297cd2920f4130ec1a4192d76f";
        private static final String host="http://ws.audioscrobbler.com";
        private static final String artistSearch="/2.0/?method=artist.search&artist=";
        public LastfmAPI(){

        }
        public String SearchForName(String nameArtist) throws UnsupportedEncodingException {
            String request=host+artistSearch+nameArtist+andkey+"&format=json";
            Request req = new Request(request);
          //  req.setData(request);
            req.setMethod("GET");
            req.setPort(80);
            //req.setData(data);
            req.send();
            Response r = Response.fromJson(req.getResponse());
            JsonElement json = new JsonParser().parse(r.getResult());
            return json.toString();
        }


}
