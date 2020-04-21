package structural;

import structural.composite.Menu;
import structural.composite.MenuItem;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CompositeTest {

    /**
     * The Composite pattern follows a tree model.
     * It's a cluster of elements of the same type (MenuComponent in our example)
     * It allows definition of root and leafs .
     * The root element knows all about the children so it's a strong model
     * But can become complex too fast (Tree complexity)
     */
    @Test
    public void should_get_technician_security_attribute_of_the_new_composite(){
        Map securityAttributes = new HashMap();
        securityAttributes.put("director", Arrays.asList("Admin", "Visitor"));
        securityAttributes.put("visitor", "Visitor");
        securityAttributes.put("technician", "Admin");

        Map compositeSrcAttributes = new HashMap();
        compositeSrcAttributes.putAll(securityAttributes);

        Assert.assertEquals("Admin", compositeSrcAttributes.get("technician"));
    }

    @Test
    public void should_print_all_menuItems_on_the_tree_recursively(){
        Menu menu = new Menu("/rootLevel");
        menu.add(new MenuItem("/level2"));
        menu.add(new MenuItem("/level2Bis"));

        Assert.assertEquals("/rootLevel\n/level2\n/level2Bis\n", menu.toString());
    }
}
