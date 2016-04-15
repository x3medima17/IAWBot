import java.io.IOException;


/**
 * Created by dumitru on 07.04.16.
 */

public class Main {
    public static void main(String args[]) throws IOException {
        Bot bot = new Bot("212445639:AAFWI61KfTxpBAZJqOnH2VuoedYHQlnO7WE");
        String me = bot.getMe();
        Response r = Response.fromJson(me);

        System.out.println(User.fromJson(r.getResult()).getId());

        //System.out.println(Response.fromJson(bot.getUpdates(0)));

    }
}
