import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


/**
 * Created by dumitru on 07.04.16.
 */

public class Main {
    public static void main(String args[]) throws IOException, InterruptedException {

        Config config = new Config("config/token.json");
        Bot bot = new Bot(config.get("token"));
        String me = bot.getMe();

        ArrayList<Tuple> handlers = new ArrayList<>();
        handlers.add(new Tuple("/hello", new HelloHandler()));
        handlers.add(new Tuple("any natural language",new NaturalLanguageHandler()));

        Application application = new Application(handlers, bot);
        application.startIoLoop();
    }


}

class HelloHandler extends CommandHandler {
    public void before() {
        System.out.println("this is before implementation");
    }

    public void handle() {
        System.out.println("This is Hello world!");


    }

    public void after() {
        System.out.println("After method");
    }

}

class NaturalLanguageHandler extends CommandHandler {

    public void before() {
        System.out.println("this is before implementation natural language");

    }

    public void handle() throws UnsupportedEncodingException {
        System.out.println("This is natural language!");
        bot.sendMessage(getChatId(), getCommand());
    }

    public void after() {
        System.out.println("After method");
    }

}