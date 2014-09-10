package me.uselocker.coderinjson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JsonArrayNode_mth_remove_Test {

    private JsonArrayNode jsonArrayNode;

    @Before
    public void setUp() throws Exception {
        jsonArrayNode = new JsonArrayNode()
                .add(1).add(2).add(3).add(4).add(5);
    }

    @Test
    public void testRemove_first() throws Exception {
        assertTrue(jsonArrayNode.remove(0).toString().equals("1"));
    }

    @Test
    public void testRemove_last() throws Exception {
        assertTrue(jsonArrayNode.remove(4).toString().equals("5"));
    }

    @Test
    public void testRemove_indexes() throws Exception {
        jsonArrayNode.remove(1);
        assertTrue(jsonArrayNode.getValue(0).toString().equals("1"));
        assertTrue(jsonArrayNode.getValue(1).toString().equals("3"));
        assertTrue(jsonArrayNode.getValue(2).toString().equals("4"));
        assertTrue(jsonArrayNode.getValue(3).toString().equals("5"));
        assertTrue(jsonArrayNode.getValue(4) == null);
    }
}
