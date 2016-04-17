import javax.xml.ws.http.HTTPException;

/**
 * Created by yermolaev on 17.04.16.
 */

/***
 * Extension of HTTPException, which also contains Telegram description message
 */
public class TelegramException extends HTTPException {

    private String telegramErrorDescription;

    TelegramException(int errorCode, String description) {
        super(errorCode);
        this.telegramErrorDescription = description;
    }

    public String getDescription() {
        return telegramErrorDescription;
    }

}
