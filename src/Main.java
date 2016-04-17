import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by dumitru on 07.04.16.
 */

public class Main {
    public static void main(String args[]) throws IOException, InterruptedException {
        Bot bot = new Bot("182348404:AAHbUrbCdHfWK4IAvx20SGkbimxLlJwE5ho");
        String me = bot.getMe();

        ArrayList<Tuple> handlers = new ArrayList<>();
        handlers.add(new Tuple("/hello",new HelloHandler()));
        handlers.add(new Tuple("/test", new TestHandler()));
        handlers.add(new Tuple("/searchartist", new SearchByArtistHandler()));
        handlers.add(new Tuple("/searchtrack", new SearchByTrackNHandler()));

        Application application = new Application(handlers, bot);
        application.startIoLoop();
    }


}

