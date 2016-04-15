import java.io.IOException;


/**
 * Created by dumitru on 07.04.16.
 */
public class Main {
    public static void main(String args[]) throws IOException {
        Bot bot = new Bot("212445639:AAFWI61KfTxpBAZJqOnH2VuoedYHQlnO7WE");
        String me = bot.getMe();
        System.out.println(me);
        System.out.println(Response.fromJson(bot.getUpdates(0)));
//        System.out.println();
        //JsonElement je = new JsonParser().parse(me);
//        String value = je.getAsJsonObject().get("result").getAsJsonObject().get("id").toString();
//        Response resp = gson.fromJson(me, Response.class);
//        System.out.println(value);

        //JSON j = new JSON("{id:5, firstName : \"Dima\", lastName : \"Savva\", username: \"x3medima17\"}");
        //j.loads(User.class);

    }
}
