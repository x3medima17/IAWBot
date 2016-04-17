package Keyboard;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by Анастасия on 17.04.2016.
 */
public class InlineKeyboardButton {
    private String	text;
    private String	url;
    private String	callbackData;
    private String	switchInlineQuery;


    public InlineKeyboardButton(String text, String url, String callbackData, String switchInlineQuery) {
        this.setText(text);
        this.setUrl(url);
        this.setCallbackData(callbackData);
        this.setSwitchInlineQuery(switchInlineQuery);
    }

    public InlineKeyboardButton(String text) {
        this(text, null, text, null);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public void setCallbackData(String callbackData) {
        this.callbackData = callbackData;
    }

    public String getSwitchInlineQuery() {
        return switchInlineQuery;
    }

    public void setSwitchInlineQuery(String switchInlineQuery) {
        this.switchInlineQuery = switchInlineQuery;
    }


    public JsonElement getJsonButton(){
        JsonObject object = new JsonObject();
        object.addProperty("text", text);
        if (url != null) {
            object.addProperty("url", url);
        }
        if (callbackData != null) {
            object.addProperty("callback_data", callbackData);
        }
        if (switchInlineQuery != null) {
            object.addProperty("switch_inline_query", switchInlineQuery);
        }
        return object;
    }
}
