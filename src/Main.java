import java.io.IOException;

import java.util.HashMap;

/**
 * Created by dumitru on 07.04.16.
 */
public class Main {
    public static void main(String args[]) {
        HashMap<String,String> data = new HashMap<>();

        Bot bot = new Bot("212445639:AAE3OrJuCIOGwnUaOrVjv20YoT-j3i6bPio");
        String chatId = "-91608308";
        String text = "Hello from Java";

        System.out.println(bot.sendMessage(chatId,text));
    }
}
