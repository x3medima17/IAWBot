package Keyboard;

import com.google.gson.JsonObject;

/**
 * Created by Анастасия on 17.04.2016.
 */
public class ForceReply {

    public boolean selective;

    public ForceReply(boolean selective) {
        this.selective = selective;
    }

    public String toString() {
        JsonObject object = new JsonObject();
        object.addProperty("force_reply", true);
        if (selective) {
            object.addProperty("selective", true);
        }
        return object.toString();
    }
}

