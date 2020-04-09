package structural;

import structural.Flyweight.OrderManagementSystem;
import org.junit.Assert;
import org.junit.Test;

public class FlyweightTest {

    @Test
    public void should_return_new_adress_Integer_if_not_already_created(){
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
