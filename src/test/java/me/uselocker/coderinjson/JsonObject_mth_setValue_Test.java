package me.uselocker.coderinjson;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class JsonObject_mth_setValue_Test {

    private String nRef = null;
    private String[] arr = {
            "Object",
            "String",
            "Integer",
            "int",
            "Double",
            "double",
            "Boolean",
            "boolean"
    };
    private JsonObject jsonObject;
    private String nullKey = null;

    @Before
    public void setUp() {
        jsonObject = new JsonObject();
        for(String s : arr) {
            jsonObject.add(s, nRef);
        }
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testSetValue_JO() throws Exception {
        JsonObject newJO = new JsonObject();
        jsonObject.setValue(arr[0], newJO);
        assertTrue(jsonObject.getValue(arr[0]).equals(newJO));
    }

    @Test
    public void testSetValue_badKey_JO() throws Exception {
        expectedEx.expect(IllegalArgumentException.class);
        jsonObject.setValue(nullKey, new JsonObject());
    }

    @Test
    public void testSetValue_String() throws Exception {
        jsonObject.setValue(arr[1], "str");
        assertTrue(jsonObject.getValue(arr[1]).equals("str"));
    }

    @Test
    public void testSetValue_badKey_String() throws Exception {
        expectedEx.expect(IllegalArgumentException.class);
        jsonObject.setValue(nullKey, "asdf");
    }

    @Test
    public void testSetValue_Integer() throws Exception {
        jsonObject.setValue(arr[2], Integer.valueOf(1));
        assertTrue(jsonObject.getValue(arr[2]).equals(1));
    }

    @Test
    public void testSetValue_badKey_Integer() throws Exception {
        expectedEx.expect(IllegalArgumentException.class);
        jsonObject.setValue(nullKey, Integer.MAX_VALUE);
    }

    @Test
    public void testSetValue_int() throws Exception {
        jsonObject.setValue(arr[3], 123);
        assertTrue(jsonObject.getValue(arr[3]).equals(123));
    }

    @Test
    public void testSetValue_Double() throws Exception {
        jsonObject.setValue(arr[4], Double.valueOf(123));
        assertTrue(jsonObject.getValue(arr[4]).equals((double) 123));
    }

    @Test
    public void testSetValue_double() throws Exception {
        jsonObject.setValue(arr[5], 123D);
        assertTrue(jsonObject.getValue(arr[5]).equals((double) 123));
    }

    @Test
    public void testSetValue_badKey_Double() throws Exception {
        expectedEx.expect(IllegalArgumentException.class);
        jsonObject.setValue(nullKey, Double.MAX_VALUE);
    }

    @Test
    public void testSetValue_Boolean() throws Exception {
        jsonObject.setValue(arr[6], Boolean.FALSE);
        assertTrue(jsonObject.getValue(arr[6]).equals(Boolean.FALSE));
    }

    @Test
    public void testSetValue_boolean() throws Exception {
        jsonObject.setValue(arr[7], true);
        assertTrue(jsonObject.getValue(arr[7]).equals(Boolean.TRUE));
    }

    @Test
    public void testSetValue_badKey_Boolean() throws Exception {
        expectedEx.expect(IllegalArgumentException.class);
        jsonObject.setValue(nullKey, Boolean.FALSE);
    }
}
