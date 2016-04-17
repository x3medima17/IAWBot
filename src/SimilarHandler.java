import java.io.UnsupportedEncodingException;

/**
 * Created by Mtrs on 17.04.2016.
 */
public class SimilarHandler extends CommandHandler {
    public void before() {
        System.out.println("find similar artists");
    }

    public void handle(Bot bot, Update update) throws UnsupportedEncodingException {

        System.out.println("looking for similar artists");
        String msg = update.getMessage().getText().substring(
                update.getMessage().getText().lastIndexOf(" ") + 1);
        System.out.println(msg);

        LastfmAPI lfm = new LastfmAPI();
        String response = lfm.searchForSimilar(msg);
        System.out.println(response);

        bot.sendMessage(update.getMessage().getChat().getId(), response);//+" "+response);
    }

    public void after() {
        System.out.println("success?");
    }
}
