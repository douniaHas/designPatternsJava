package behavioral.visitor.oldway;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    List<Part> parts = new ArrayList<>();

    public void add(Part part){
        parts.add(part);
    }

    public long calculateShipping(){
        long shipping = 0;
        for (Part p:parts
             ) {
            shipping += p.calculateShipping();
        }
        return shipping;
    }
}
