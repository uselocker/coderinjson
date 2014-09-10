package me.uselocker.coderinjson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JsonArrayNode_mth_Set_Test {

    private JsonObject jsonObject;
    private JsonArrayNode jsonArrayNode;
    private JsonArrayNode NEWjsonArrayNode;

    @Before
    public void setUp() throws Exception {
        jsonArrayNode = new JsonArrayNode()
                .add("0").add("1").add("2")
                .add("3").add("4").add("5")
                .add("6").add("7").add("8");
        jsonObject = new JsonObject();
        NEWjsonArrayNode = new JsonArrayNode();
    }

    @Test
    public void testSetValue_JO() throws Exception {
        jsonArrayNode.setValue(0, jsonObject);
        assertTrue(jsonArrayNode.getValue(0).equals(jsonObject));
    }

    @Test
    public void testSetValue_JAN() throws Exception {
        jsonArrayNode.setValue(1, NEWjsonArrayNode);
        assertTrue(jsonArrayNode.getValue(1).equals(NEWjsonArrayNode));
    }

    @Test
    public void testSetValue_int() throws Exception {
        jsonArrayNode.setValue(2, 123);
        assertTrue(jsonArrayNode.getValue(2).equals(123));
    }

    @Test
    public void testSetValue_Integer() throws Exception {
        jsonArrayNode.setValue(3, new Integer(123));
        assertTrue(jsonArrayNode.getValue(3).equals(123));
    }

    @Test
    public void testSetValue_dbl() throws Exception {
        jsonArrayNode.setValue(4, 123.4);
        assertTrue(jsonArrayNode.getValue(4).equals(123.4));
    }

    @Test
    public void testSetValue_Double() throws Exception {
        jsonArrayNode.setValue(5, new Double(123.4));
        assertTrue(jsonArrayNode.getValue(5).equals(123.4));
    }

    @Test
    public void testSetValue_boolean() throws Exception {
        jsonArrayNode.setValue(6, true);
        assertTrue(jsonArrayNode.getValue(6).equals(true));
    }

    @Test
    public void testSetValue_Boolean() throws Exception {
        jsonArrayNode.setValue(7, Boolean.TRUE);
        assertTrue(jsonArrayNode.getValue(7).equals(true));
    }

    @Test
    public void testSetValue_String() throws Exception {
        jsonArrayNode.setValue(8, "asd");
        assertTrue(jsonArrayNode.getValue(8).equals("asd"));
    }
}
