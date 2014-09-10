package me.uselocker.coderinjson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JsonArrayNode_mth_Get_Test {

    private JsonObject jsonObject;
    private JsonArrayNode jsonArrayNode;
    private JsonArrayNode NEWjsonArrayNode;

    @Before
    public void setUp() throws Exception {
        jsonObject = new JsonObject();
        NEWjsonArrayNode = new JsonArrayNode();
        jsonArrayNode = new JsonArrayNode()
                .add("0")
                .add("1")
                .add("2")
                .add("3")
                .add(jsonObject)
                .add(NEWjsonArrayNode);
    }

    @Test
    public void testGetValue_firstIndex() throws Exception {
        assertTrue(jsonArrayNode.getValue(0).equals("0"));
    }

    @Test
    public void testGetValue_JO() throws Exception {
        assertTrue(jsonArrayNode.getValue(4).equals(jsonObject));
    }

    @Test
    public void testGetValue_JAN() throws Exception {
        assertTrue(jsonArrayNode.getValue(5).equals(NEWjsonArrayNode));
    }

    @Test
    public void testGetValue_notExistMinIndex() throws Exception {
        assertTrue(jsonArrayNode.getValue(Integer.MIN_VALUE) == null);
    }

    @Test
    public void testGetValue_notExistMaxIndex() throws Exception {
        assertTrue(jsonArrayNode.getValue(Integer.MAX_VALUE) == null);
    }
}
