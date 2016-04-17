import java.io.UnsupportedEncodingException;

/**
 * Created by dumitru on 17.04.16.
 */
public  abstract class CommandHandler {
    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public int getChartId() {
        return chartId;
    }

    public void setChartId(int chartId) {
        this.chartId = chartId;
    }

    Bot bot;
    String command;
    int chartId;

    public int getChatId() {
        return chartId;
    }

    public void setChatId(int chartId) {
        this.chartId = chartId;
    }

    public String setCommand(String command){
        this.command = command;
        return command;
    }
    public String getCommand()
    {
        return command;
    }
    public void handle() throws UnsupportedEncodingException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void before() {

    }

    public void after(){

    }
}
