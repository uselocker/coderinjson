package me.uselocker.coderinjson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JsonDoubleNodeTest {

    private String key = "key";
    private Double value = 1000D;
    private JsonDoubleNode jsonDoubleNode;

    @Before
    public void setUp() throws Exception {
        jsonDoubleNode = new JsonDoubleNode(key, value);
    }

    @Test
    public void testGetKey() throws Exception {
        assertTrue(jsonDoubleNode.getKey().equals("\"" + key + "\""));
    }

    @Test
    public void testGetJSONString() throws Exception {
        assertTrue(jsonDoubleNode.getJsonBuilder().toString().equals(value.toString()));
    }

    @Test
    public void testGetValue() throws Exception {
        assertTrue(jsonDoubleNode.getValue(key).equals(value));
    }
}
