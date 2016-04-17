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
            if(handler.x.equals(command)) {
                result = (CommandHandler) handler.y;
            }
        }
        if (result == null){
            result = findHandler("any natural language");
        }
        return result;
    }

    private void runHandler(CommandHandler handler) throws IOException {
        handler.before();
        handler.handle();
        handler.after();
    }

    public void startIoLoop() throws IOException, InterruptedException {
        while (true) {
            ArrayList<Update> updates = bot.getUpdates(offset);
            for (Update update : updates) {
                String command = update.getMessage().getText();
                offset = update.getUpdateId()+1;
                CommandHandler handler = findHandler(command);

                if(handler != null){
                    handler.setBot(bot);
                    handler.setChatId(update.getMessage().getChat().getId());
                    handler.setCommand(command);
                    runHandler(handler);
                }
                System.out.println(command);

            }
            Thread.sleep(400);
        }
    }
}
