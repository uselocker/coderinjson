package me.uselocker.coderinjson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JsonObject_mth_getValue_Test {

    private String nullKey= null;
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
    public void testGetValue_direct() throws Exception {
        assertTrue(jsonObject.getValue(key).equals(value));
    }

    @Test
    public void testGetValue_nested() throws Exception {
        assertTrue(jsonObject.getValue(key+"nested").equals(value + "nested"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetValue_badKey() throws Exception {
        jsonObject.getValue(nullKey);
    }

}
