import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dumitru on 14.04.16.
 */

public class JSON {
    private String str;

    public JSON(String str) {
        this.str = str;
    }

    public Object loads(Class c) {
        System.out.println(c.getName());
        JsonElement json = new JsonParser().parse(str);

        Object obj = new Object();
        Field field;
        try {
            obj = c.newInstance();
            for (Field item : Arrays.asList(c.getDeclaredFields())) {
                System.out.printf("%s %s\n",item.getName(),item.getType());
                field = c.getDeclaredField(item.getName());
                field.setAccessible(true);
//                field.set(obj,json.getAsJsonObject().get(item.getName()).getAs)

            }
        } catch (Throwable e) {
            System.err.println(e);
        }


        return obj;
    }
}
