import java.io.UnsupportedEncodingException;

/**
 * Created by bbr on 17.04.16.
 */
public class SearchByTrackNHandler extends CommandHandler {

    public void before() {
        System.out.println("search by track name");
    }

    public void handle(Bot bot, Update update) throws UnsupportedEncodingException {

        System.out.println("this is the search by name of the track");
        String msg=update.getMessage().getText().substring(
                update.getMessage().getText().lastIndexOf(" ")+1);
        System.out.println(msg);

        LastfmAPI lastik=new LastfmAPI();
        String response=lastik.searchForTrack(msg);
        System.out.println(response);

        bot.sendMessage(update.getMessage().getChat().getId(), response.replaceAll("\"",""));//+" "+response);
    }

    public void after() {
        System.out.println("success?");
    }

}
