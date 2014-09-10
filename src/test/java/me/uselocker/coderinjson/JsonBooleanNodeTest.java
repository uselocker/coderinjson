package me.uselocker.coderinjson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JsonBooleanNodeTest {
    
    private String key = "key";
    private Boolean value = Boolean.TRUE;
    private JsonBooleanNode jsonBooleanNode;
    
    @Before
    public void setUp() throws Exception {
        jsonBooleanNode = new JsonBooleanNode(key, value);
    }

    @Test
    public void testGetKey() throws Exception {
        assertTrue(jsonBooleanNode.getKey().equals("\"" + key + "\""));
    }

    @Test
    public void testGetJSONString() throws Exception {
        assertTrue(jsonBooleanNode.getJsonBuilder().toString().equals(value.toString()));
    }

    @Test
    public void testGetValue() throws Exception {
        assertTrue(jsonBooleanNode.getValue(key).equals(Boolean.TRUE));
    }
}
