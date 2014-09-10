package me.uselocker.coderinjson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class JsonArrayNode_mth_Add_Test {

    private JsonObject jsonObject;
    private JsonArrayNode jsonArrayNode;
    private JsonArrayNode NEWjsonArrayNode;

    @Before
    public void setUp() throws Exception {
        jsonArrayNode = new JsonArrayNode();
        jsonObject = new JsonObject();
        NEWjsonArrayNode = new JsonArrayNode();
    }

    @Test
    public void testAdd_String() throws Exception {
        jsonArrayNode.add("123");
        assertTrue(jsonArrayNode.getValue(0).equals("123"));
    }

    @Test
    public void testAdd_int() throws Exception {
        jsonArrayNode.add(123);
        assertTrue(jsonArrayNode.getValue(0).equals(123));
    }

    @Test
    public void testAdd_Integer() throws Exception {
        jsonArrayNode.add(new Integer(123));
        assertTrue(jsonArrayNode.getValue(0).equals(123));
    }

    @Test
    public void testAdd_JO() throws Exception {
        jsonArrayNode.add(jsonObject);
        assertTrue(jsonArrayNode.getValue(0).equals(jsonObject));
    }

    @Test
    public void testAdd_JAN() throws Exception {
        jsonArrayNode.add(NEWjsonArrayNode);
        assertTrue(jsonArrayNode.getValue(0).equals(NEWjsonArrayNode));
    }

    @Test
    public void testAdd_dbl() throws Exception {
        jsonArrayNode.add(123.4);
        assertTrue(jsonArrayNode.getValue(0).equals(123.4));
    }

    @Test
    public void testAdd_Double() throws Exception {
        jsonArrayNode.add(new Double(123.4));
        assertTrue(jsonArrayNode.getValue(0).equals(123.4));
    }

    @Test
    public void testAdd_boolean() throws Exception {
        jsonArrayNode.add(true);
        assertTrue(jsonArrayNode.getValue(0).equals(true));
    }

    @Test
    public void testAdd_Boolean() throws Exception {
        jsonArrayNode.add(Boolean.TRUE);
        assertTrue(jsonArrayNode.getValue(0).equals(true));
    }
}
