package structural;

import structural.Flyweight.OrderManagementSystem;
import org.junit.Assert;
import org.junit.Test;

public class FlyweightTest {

    /**
     * Flyweight Pattern is a pattern used for performance issues.
     * It uses a cache system with a factory (Catalog). It's transparent for the client.
     * It's a refactoring pattern.
     * It's a pattern of patterns (factory + flyweight)
     * It's important that the catalog and the objects created are immutable
     */

    @Test
    public void should_return_new_address_Integer_if_not_already_created(){
        Integer intA = Integer.valueOf(5);
        Integer intB = Integer.valueOf(5);
        Integer intC = Integer.valueOf(12);

        Assert.assertEquals(System.identityHashCode(intA),System.identityHashCode(intB));
        Assert.assertNotEquals(System.identityHashCode(intA),System.identityHashCode(intC));
    }

    @Test
    public void should_add_only_if_not_present_to_order_management_system(){
        OrderManagementSystem ims = new OrderManagementSystem();

        ims.takeOrder("Roomba", 221);
        ims.takeOrder("Bose Headphones", 361);
        ims.takeOrder("Samsung TV", 432);
        ims.takeOrder("Samsung TV", 323);
        ims.takeOrder("Roomba", 563);
        ims.takeOrder("Bose Headphones", 321);
        ims.takeOrder("Roomba", 234);
        ims.takeOrder("Samsung TV", 54);
        ims.takeOrder("Roomba", 34);
        ims.takeOrder("Bose Headphones", 365);
        ims.takeOrder("Samsung TV", 332);
        ims.takeOrder("Roomba", 456);

        Assert.assertEquals(3,ims.report());
    }

}
