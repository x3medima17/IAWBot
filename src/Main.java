import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


/**
 * Created by dumitru on 07.04.16.
 */

public class Main {
    public static void main(String args[]) throws IOException, InterruptedException {
        Bot bot = new Bot("182400236:AAEQD1-dCo0PywmozSlFM8nD3ImJ0-UepRA");
        String me = bot.getMe();

        ArrayList<Tuple> handlers = new ArrayList<>();
        handlers.add(new Tuple("/hello",new HelloHandler()));
        handlers.add(new Tuple("/test", new TestHandler()));

        Application application = new Application(handlers, bot);
        application.startIoLoop();
    }


}

