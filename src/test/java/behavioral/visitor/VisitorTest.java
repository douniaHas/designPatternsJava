package behavioral.visitor;

import behavioral.visitor.newWay.*;
import org.junit.Test;

public class VisitorTest {

    @Test
    public void should_calculate_shipping_as_adding_a_visitor(){
        Vehicle vehicle = new Vehicle();

        vehicle.add(new Wheel());
        vehicle.add(new Oil());
        vehicle.add(new Board());

        vehicle.accept(new ShippingVisitor());
        vehicle.accept(new DisplayVisitor());
    }
}
