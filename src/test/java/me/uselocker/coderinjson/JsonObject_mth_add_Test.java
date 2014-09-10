package me.uselocker.coderinjson;

import me.uselocker.coderinjson.exception.CyclicLinkException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JsonObject_mth_add_Test {

    private String nullStr = null;
    private String nullKey = null;
    private JsonObject jsonObject;
    private JsonObject newJO;
    private JsonArrayNode newJAN;

    @Before
    public void setUp() throws Exception {
        jsonObject = new JsonObject();
        newJO = new JsonObject();
        newJAN = new JsonArrayNode();
    }

    @Test
    public void testAdd_JO() throws Exception {
        jsonObject.add("keyJO", newJO);
        assertTrue(jsonObject.getValue("keyJO").equals(newJO));
    }

    @Test
    public void testAdd_JAN() throws Exception {
        jsonObject.add("keyJAN", newJAN);
        assertTrue(jsonObject.getValue("keyJAN").equals(newJAN));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd_badKey_JO() throws Exception {
        jsonObject.add(nullKey, newJO);
    }

    @Test(expected = CyclicLinkException.class)
    public void testAdd_addCyclicLink() throws Exception {
        jsonObject.add("cyclicLink", jsonObject);
    }

    @Test
    public void testAdd_addJOnull() throws Exception {
        jsonObject.add("nullStr", nullStr);
        assertTrue(jsonObject.getValue("nullStr") == null);
    }

    @Test
    public void testAdd_Boolean() throws Exception {
        jsonObject.add("Boolean", Boolean.TRUE);
        assertTrue(jsonObject.getValue("Boolean").equals(Boolean.TRUE));
    }

    @Test
    public void testAdd_boolean() throws Exception {
        jsonObject.add("boolean", true);
        assertTrue(jsonObject.getValue("boolean").equals(Boolean.TRUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd_badKey_Boolean() throws Exception {
        jsonObject.add(nullKey, Boolean.TRUE);
    }

    @Test
    public void testAdd_String() throws Exception {
        jsonObject.add("str", "str");
        assertTrue(jsonObject.getValue("str").equals("str"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd_badKey_Str() throws Exception {
        jsonObject.add(nullKey, "asd");
    }

    @Test
    public void testAdd_Int() throws Exception {
        jsonObject.add("Integer", Integer.MAX_VALUE);
        assertTrue(jsonObject.getValue("Integer").equals(Integer.MAX_VALUE));
    }

    @Test
    public void testAdd_int() throws Exception {
        jsonObject.add("int", 1000);
        assertTrue(jsonObject.getValue("int").equals(1000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd_badKey_Integer() throws Exception {
        jsonObject.add(nullKey, Integer.MAX_VALUE);
    }

    @Test
    public void testAdd_Double() throws Exception {
        jsonObject.add("Double", Double.MAX_VALUE);
        assertTrue(jsonObject.getValue("Double").equals(Double.MAX_VALUE));
    }

    @Test
    public void testAdd_double() throws Exception {
        jsonObject.add("double", 1000D);
        assertTrue(jsonObject.getValue("double").equals((double) 1000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd_badKey_Double() throws Exception {
        jsonObject.add(nullKey, Double.MAX_VALUE);
    }
}
