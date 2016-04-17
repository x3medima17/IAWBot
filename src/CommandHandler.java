import java.io.UnsupportedEncodingException;

/**
 * Created by dumitru on 17.04.16.
 */
public abstract class CommandHandler {
    public void handle(Bot bot, Update update) throws UnsupportedEncodingException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void before() {

    }

    public void after(){

    }
}
