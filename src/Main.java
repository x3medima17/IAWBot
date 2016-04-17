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

class TestHandler extends CommandHandler{
    public void before() {
        System.out.println("before test");
    }

    public void handle(Bot bot, Update update) throws UnsupportedEncodingException {

        System.out.println("this is the test");
        bot.sendMessage(update.getMessage().getChat().getId(), "test answer");
    }

    public void after() {
        System.out.println("success");
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