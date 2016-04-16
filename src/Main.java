import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by dumitru on 07.04.16.
 */

public class Main {
    public static void main(String args[]) throws IOException, InterruptedException {
        Bot bot = new Bot("212445639:AAFWI61KfTxpBAZJqOnH2VuoedYHQlnO7WE");
        String me = bot.getMe();

        int offset = 0;
        while(true){
            Response r = Response.fromJson(bot.getUpdates(offset));
            JsonElement json = new JsonParser().parse(r.getResult());

            for (JsonElement item : json.getAsJsonArray()) {
                Update curr =  Update.fromJson(item.toString());
                offset = curr.getUpdateId()+1;
                System.out.println(curr.getMessage().getText());
                bot.sendMessage(curr.getMessage().getChat().getId(), curr.getMessage().getText());
            }
            Thread.sleep(1000);
        }

    }
}
