package structural;

import structural.composite.Menu;
import structural.composite.MenuItem;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CompositeTest {
    @Test
    public void should_grap_sec_attributes_of_director(){
        Map securityAttributes = new HashMap();
        securityAttributes.put("director", Arrays.asList("Admin", "Visitor"));
        securityAttributes.put("visitor", "Visitor");
        securityAttributes.put("technician", "Admin");

        Assert.assertEquals("Admin", securityAttributes.get("technician"));
    }

    @Test
    public void should_print_all_menuItems_on_the_tree_recursively(){
        Menu menu = new Menu("/rootLevel");
        menu.add(new MenuItem("/level2"));
        menu.add(new MenuItem("/level2Bis"));

        Assert.assertEquals("/rootLevel\n/level2\n/level2Bis\n", menu.toString());
    }
}
