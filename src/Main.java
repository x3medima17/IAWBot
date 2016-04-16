import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by dumitru on 07.04.16.
 */

public class Main {
    public static void main(String args[]) throws IOException, InterruptedException {
        Bot bot = new Bot("212445639:AAFWI61KfTxpBAZJqOnH2VuoedYHQlnO7WE");
        String me = bot.getMe();

        ArrayList<Tuple> handlers = new ArrayList<>();
        handlers.add(new Tuple("/hello",new HelloHandler()));


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