import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by Solipsist-R on 17.04.2016.
 */
public class LastfmAPI {
    private static final String key = "288246297cd2920f4130ec1a4192d76f";
    private static final String andkey = "&api_key=288246297cd2920f4130ec1a4192d76f";
    private static final String host = "http://ws.audioscrobbler.com";
    private static final String artistSearch = "/2.0/?method=artist.search&artist=";
    private static final String trackSearch = "/2.0/?method=track.search&track=";

    public LastfmAPI() {

    }

    public String searchForTrackAndArtist(String trackAndArtist) throws UnsupportedEncodingException {
        String request = host + trackSearch + trackAndArtist + andkey + "&format=json";
        Request req = new Request(request);
        req.setMethod("GET");
        req.setPort(80);
        req.send();
        ResponseLast r = ResponseLast.fromJsonTrack(req.getResponse());

        JsonElement json = new JsonParser().parse(r.getResult());
        return json.toString();
    }

    public String searchForTrack(String track) throws UnsupportedEncodingException {
        String request = host + trackSearch + track + andkey + "&format=json";
        Request req = new Request(request);
        req.setMethod("GET");
        req.setPort(80);
        req.send();
        ResponseLast r = ResponseLast.fromJsonTrack(req.getResponse());

        JsonElement json = new JsonParser().parse(r.getResult());
        return json.toString();
    }

    public String SearchForName(String nameArtist) throws UnsupportedEncodingException {
        String request = host + artistSearch + nameArtist + andkey + "&format=json";
        Request req = new Request(request);
        req.setMethod("GET");
        req.setPort(80);
        req.send();
        ResponseLast r = ResponseLast.fromJson(req.getResponse());

        JsonElement json = new JsonParser().parse(r.getResult());
        return json.toString();
    }

    private static class ResponseLast {
        private String resulturl;
        private String description;

        ResponseLast(String resulturl, String description) {
            this.resulturl = resulturl;
            this.description = description;
        }

        String getResult() {
            return resulturl;
        }

        static ResponseLast fromJsonTrack(String raw) {
            if (!raw.isEmpty()) {
                JsonElement json = new JsonParser().parse(raw);
                JsonElement results = json.getAsJsonObject().get("results");
                System.out.println(results);
                JsonElement artists = results.getAsJsonObject().get("trackmatches").getAsJsonObject();
                String resulturl = "";
                if (!artists.isJsonNull()) {
                    JsonElement artist = artists.getAsJsonObject().get("track").getAsJsonArray().get(0);
                    resulturl = artist.getAsJsonObject().get("url").toString();
                }

                String description = "just a description";
                return new ResponseLast(resulturl, description);
            }
            return new ResponseLast("", "");
        }

        static ResponseLast fromJson(String raw) {
            if (!raw.isEmpty()) {
                JsonElement json = new JsonParser().parse(raw);
                JsonElement results = json.getAsJsonObject().get("results");
                System.out.println(results);
                JsonElement artists = results.getAsJsonObject().get("artistmatches").getAsJsonObject();
                String resulturl = "";
                if (!artists.isJsonNull()) {
                    JsonElement artist = artists.getAsJsonObject().get("artist").getAsJsonArray().get(0);
                    resulturl = artist.getAsJsonObject().get("url").toString();
                }

                String description = "just a description";
                return new ResponseLast(resulturl, description);
            }
            return new ResponseLast("", "");
        }

    }


}
