package me.uselocker.coderinjson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JsonIntNodeTest {

    private String key = "key";
    private Integer value = Integer.valueOf(10000);
    private JsonIntNode jsonIntNode;

    @Before
    public void setUp() throws Exception {
        jsonIntNode = new JsonIntNode(key, value);
    }

    @Test
    public void testGetKey() throws Exception {
        assertTrue(jsonIntNode.getKey().equals("\"" + key + "\""));
    }

    @Test
    public void testGetJSONString() throws Exception {
        assertTrue(jsonIntNode.getJsonBuilder().toString().equals(value.toString()));
    }

    @Test
    public void testGetValue() throws Exception {
        assertTrue(jsonIntNode.getValue(key).equals(value));
    }
}
