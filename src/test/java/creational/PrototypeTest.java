package creational;

import creational.prototype.shallowCopy.Report;
import creational.prototype.shallowCopy.ShallowCopy;
import creational.prototype.shallowCopyFacilitated.Registry;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PrototypeTest {

    @Test
    public void should_shallow_clone() throws CloneNotSupportedException {
        ShallowCopy copy = new ShallowCopy("this is my SQL sentence", Arrays.asList("sql"), new Report());
        ShallowCopy clone = copy.clone();

        assertEquals("this is my SQL sentence", clone.getSql());
        assertEquals(copy.getReport(), clone.getReport());
    }

    @Test
    public void should_build_complex_object_easily(){
        Registry registryPrefilled = new Registry();
        Registry copy = registryPrefilled.clone();

        assertTrue(registryPrefilled.getItems().containsKey("movie_star"));
        assertEquals("Dune", registryPrefilled.getItems().get("book_star").getTitle());

        assertTrue(copy.getItems().containsKey("movie_cloned"));
        assertEquals("Dune", copy.getItems().get("book_cloned").getTitle());
        assertNotEquals(registryPrefilled.getItems().get("book_star"), copy.getItems().get("book_cloned"));
    }
}
