import java.io.UnsupportedEncodingException;

/**
 * Created by Mtrs on 17.04.2016.
 */
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

