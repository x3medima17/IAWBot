import java.io.UnsupportedEncodingException;

/**
 * Created by Solipsist-R on 17.04.2016.
 */
public class SearchByArtistHandler extends CommandHandler{
    public void before() {
        System.out.println("search by artist name");
    }

    public void handle(Bot bot, Update update) throws UnsupportedEncodingException {

        System.out.println("this is the search by name of the artist");
        String msg=update.getMessage().getText().substring(
                update.getMessage().getText().lastIndexOf(" ")+1);
        System.out.println(msg);

        LastfmAPI lastik=new LastfmAPI();
        String response=lastik.SearchForName(msg);
        System.out.println(response);

        bot.sendMessage(update.getMessage().getChat().getId(), response.replaceAll("\"",""));//+" "+response);
    }

    public void after() {
        System.out.println("success?");
    }
}

