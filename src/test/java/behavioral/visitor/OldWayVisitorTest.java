package behavioral.visitor;

import behavioral.visitor.oldway.Board;
import behavioral.visitor.oldway.Oil;
import behavioral.visitor.oldway.Vehicle;
import behavioral.visitor.oldway.Wheel;
import org.junit.Assert;
import org.junit.Test;

public class OldWayVisitorTest {

    @Test
    public void should_calculate_shipping_cost_of_all_vehicle_parts(){
        Vehicle vehicle = new Vehicle();

        vehicle.add(new Wheel());
        vehicle.add(new Board());
        vehicle.add(new Oil());

        Assert.assertEquals(40L, vehicle.calculateShipping());
    }


}
