import java.io.UnsupportedEncodingException;

/**
 * Created by Mtrs on 17.04.2016.
 */
class HelloHandler extends CommandHandler {
    public void before() {
        System.out.println("this is before implementation");
    }

    public void handle(Bot bot, Update update) throws UnsupportedEncodingException {
        System.out.println("This is Hello world!");
        bot.sendMessage(update.getMessage().getChat().getId(), "Hello");

    }

    public void after() {
        System.out.println("After method");
    }

}