import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Scanner;

/**
 * Created by yermolaev on 17.04.16.
 */
public class HttpConnectionCodeHandler {

    /***
     * method checks connection state and throws exception if response code is not OK (200)
     * @param connection connection to check
     * @throws NullPointerException if connection == null
     * @throws IOException
     * @throws HTTPException if response code is not 200
     */
    public static void handle(HttpURLConnection connection) throws NullPointerException, IOException, HTTPException {
        if (connection == null)
            throw new NullPointerException("Connection is null");

        int respCode = connection.getResponseCode();

        String response = "";
        if (respCode != HttpURLConnection.HTTP_OK) {
            try (Scanner scanner = new Scanner(connection.getErrorStream())) {
                scanner.useDelimiter("\\Z");
                response = scanner.next();
                System.out.println(response);
            }
            throw new HTTPException(respCode);
        }
    }

}
