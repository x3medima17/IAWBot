package Keyboard;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Created by Анастасия on 17.04.2016.
 */
public class InlineKeyboardMarkup extends Keyboard {
    private  InlineKeyboardButton[][] keyboard;

    public InlineKeyboardMarkup(InlineKeyboardButton[][] keyboard) {
        this.keyboard = keyboard;
    }

    public InlineKeyboardMarkup(String[][] buttons){
        InlineKeyboardButton[][] keyboard = new InlineKeyboardButton[buttons.length][];
        for (int i = 0; i < buttons.length; i++) {
            keyboard[i] = new InlineKeyboardButton[buttons[i].length];
            for (int j = 0; j < buttons[i].length; j++) {
                keyboard[i][j] = new InlineKeyboardButton(buttons[i][j]);
            }
        }
        this.keyboard = keyboard;
    }


    @Override
    public String toString() {
        JsonArray keyboard = new JsonArray();
        for (int i = 0; i < this.keyboard.length; i++) {
            JsonArray innerArray = new JsonArray();
            for (int j = 0; j < this.keyboard[i].length; j++) {
                innerArray.add(this.keyboard[i][j].getJsonButton());
            }
            keyboard.add(innerArray);
        }
        JsonObject object = new JsonObject();
        object.add("inline_keyboard", keyboard);
        return object.toString();
    }

}
