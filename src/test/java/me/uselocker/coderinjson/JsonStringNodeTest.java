package me.uselocker.coderinjson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JsonStringNodeTest {

    private String key = "key";
    private String value = "value";
    private JsonStringNode jsonStringNode;

    @Before
    public void setUp() throws Exception {
        jsonStringNode = new JsonStringNode(key, value);
    }

    @Test
    public void testGetKey() {
        assertTrue(jsonStringNode.getKey().equals("\"" + key + "\""));
    }

    @Test
    public void testGetJSONString() throws Exception {
        assertTrue(jsonStringNode.getJsonBuilder().toString().equals("\"" + value + "\""));
    }

    @Test
    public void testGetValue() throws Exception {
        assertTrue(jsonStringNode.getValue(key).equals(value));
    }
}
