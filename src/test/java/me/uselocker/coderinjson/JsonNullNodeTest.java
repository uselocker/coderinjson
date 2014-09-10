package me.uselocker.coderinjson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JsonNullNodeTest {

    private String key = "key";
    private JsonNullNode jsonNullNode;

    @Before
    public void setUp() throws Exception {
        jsonNullNode = new JsonNullNode(key);
    }


    @Test
    public void testGetKey() throws Exception {
        assertTrue(jsonNullNode.getKey().equals("\"" + key + "\""));
    }

    @Test
    public void testGetValue() throws Exception {
        assertTrue(jsonNullNode.getValue(key) == null);
    }

    @Test
    public void testGetJSONString() throws Exception {
        assertTrue(jsonNullNode.getJsonBuilder().toString().equals("null"));
    }

}
