package creational;

import creational.prototype.shallowCopy.Report;
import creational.prototype.shallowCopy.Request;
import creational.prototype.shallowCopyFacilitated.Registry;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
//*
public class PrototypeTest {
    /**
     * A prototype gives a fresh copy (shallow or deep as you like) of yourself at a low cost
     * Can be user for performance issues, with complex, high-cost objects
     * The Prototype takes care of the complexity of the copy instead of the client
     * It's used to be a refactored pattern
     * @throws CloneNotSupportedException
     */

    @Test
    public void should_shallow_copy() throws CloneNotSupportedException {
        Request request = new Request("this is my SQL sentence", Arrays.asList("sql"), new Report());
        Request clone = request.clone();

        assertEquals("this is my SQL sentence", clone.getSql());
        assertEquals(request.getReport(), clone.getReport());
    }

    @Test
    public void should_create_copy_complex_object_easily(){
        Registry registryPrefilled = new Registry();
        Registry copy = registryPrefilled.clone();

        assertTrue(copy.getItems().containsKey("fruit_cloned"));
        assertEquals("mango", copy.getItems().get("fruit_cloned").getTitle());
        assertNotEquals(registryPrefilled.getItems().get("star_vegetable"), copy.getItems().get("vegetable_cloned"));
    }
}
