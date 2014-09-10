package me.uselocker.coderinjson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JsonObject_mutable_Test {

    Double d = 12345d;
    Integer i = 54321;
    Boolean b = Boolean.FALSE;
    JsonObject jsonObject;

    @Before
    public void setUp() throws Exception {
        jsonObject = new JsonObject()
                .add("d", d)
                .add("i", i)
                .add("b", b);
    }

    @Test
    public void testAttackOnDataByOldRef_Double_Test() throws Exception {
        d = (double) 111111111;
        assertTrue(jsonObject.getValue("d").equals(12345d));
    }

    @Test
    public void testAttackOnDataByOldRef_Integer_Test() throws Exception {
        i = 67544747;
        assertTrue(jsonObject.getValue("i").equals(54321));
    }

    @Test
    public void testAttackOnDataByOldRef_Boolean_Test() throws Exception {
        b = true;
        assertTrue(jsonObject.getValue("b").equals(Boolean.FALSE));
    }
}
