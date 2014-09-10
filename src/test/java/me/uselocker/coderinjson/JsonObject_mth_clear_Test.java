package me.uselocker.coderinjson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JsonObject_mth_clear_Test {

    private final String str = new JsonObject().getJSON();
    private JsonObject jsonObject;

    @Before
    public void setUp() throws Exception {
        jsonObject = new JsonObject().add("123", "abc");
    }

    @Test
    public void testClear() throws Exception {
        jsonObject.clear();
        assertTrue(jsonObject.getJSON().equals(str));
    }
}
