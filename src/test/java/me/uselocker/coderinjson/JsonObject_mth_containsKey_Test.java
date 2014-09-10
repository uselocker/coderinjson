package me.uselocker.coderinjson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JsonObject_mth_containsKey_Test {

    private String nullKey = null;
    private String key = "key";
    private String value = "value";
    private JsonObject jsonObject;

    @Before
    public void setUp() throws Exception {
        jsonObject = new JsonObject()
                .add(key, value)
                .add(key + "jo", new JsonObject().add(key+"nested", value+"nested"));
    }

    @Test
    public void testContainsKey_direct() throws Exception {
        assertTrue(jsonObject.containsKey(key));
    }

    @Test
    public void testContainsKey_nested() throws Exception {
        assertTrue(jsonObject.containsKey(key+"nested"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContainsKey_badKey() throws Exception {
        jsonObject.containsKey(nullKey);
    }
}
