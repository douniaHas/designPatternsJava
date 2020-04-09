package behavioral.visitor.newWay;

import java.util.ArrayList;
import java.util.List;

public class Vehicle extends Part{
    private List<Part> parts = new ArrayList<>();

    public void add(Part part){
        parts.add(part);
    }

    @Override
    public void  accept(Visitor visitor){
        for (Part p:parts
             ) {
            p.accept(visitor);
        }
        visitor.visit(this);
    }

    public List<Part> getParts() {
        return parts;
    }
}
