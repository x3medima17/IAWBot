import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void testGet() throws Exception {
        Config config = new Config("config/token.json");

        assert(!config.get("token").equals(null));
    }
}