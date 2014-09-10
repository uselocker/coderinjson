package me.uselocker.coderinjson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JsonObject_mth_remove_Test {

    private String nullKey= null;
    private String nestedKey = "nestedKey";
    private JsonObject jsonObject;

    @Before
    public void setUp() throws Exception {
        JsonObject nestedJO = new JsonObject()
                .add("a", "a")
                .add("b", "b")
                .add("c", "c");
        jsonObject = new JsonObject()
                .add("1", "1")
                .add("2", "2")
                .add("3", "3")
                .add(nestedKey, nestedJO);
    }

    @Test
    public void testRemove_first_direct() throws Exception {
        jsonObject.remove("a");
        assertFalse(jsonObject.containsKey("a"));
    }

    @Test
    public void testRemove_first_nested() throws Exception {
        jsonObject.remove("1");
        assertFalse(jsonObject.containsKey("1"));
    }

    @Test
    public void testRemove_last_direct() throws Exception {
        jsonObject.remove("c");
        assertFalse(jsonObject.containsKey("c"));
    }

    @Test
    public void testRemove_last_nested() throws Exception {
        jsonObject.remove("3");
        assertFalse(jsonObject.containsKey("3"));
    }

    @Test
    public void testRemove_nested_structure() throws Exception {
        jsonObject.remove(nestedKey);
        assertFalse(jsonObject.containsKey(nestedKey));
    }

    @Test
    public void testRemove_empty() throws Exception {
        assertTrue(jsonObject.remove("$#^kdlgsldke42434tg54g4g") == null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemove_badKey() throws Exception {
        jsonObject.remove(nullKey);
    }
}
