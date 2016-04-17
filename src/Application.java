import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by dumitru on 17.04.16.
 */
public class Application {
    private ArrayList<Tuple> handlers;
    private Bot bot;
    private int offset;

    public Application(ArrayList<Tuple> handlers, Bot bot) {
        this.handlers = handlers;
        this.bot = bot;
        this.offset = 0;
    }

    private CommandHandler findHandler(String command){
        CommandHandler result = null;
        for(Tuple handler : handlers){
            if(handler.x.equals(command))
                result = (CommandHandler)handler.y;
        }
        return result;
    }

    private void runHandler(CommandHandler handler, Bot bot, Update update) throws UnsupportedEncodingException {
        handler.before();
        handler.handle(bot, update);
        handler.after();
    }

    public void startIoLoop() throws IOException, InterruptedException {
        while (true) {
            ArrayList<Update> updates = bot.getUpdates(offset);
            for (Update update : updates) {
                String commandRaw = update.getMessage().getText();
                String command=commandRaw.split(" ")[0];
                offset = update.getUpdateId()+1;
                CommandHandler handler = findHandler(command);

                if(handler != null){
                    runHandler(handler, bot, update);
                }
                System.out.println(command);

            }
            Thread.sleep(400);
        }
    }
}
