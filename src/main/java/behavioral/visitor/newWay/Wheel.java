package behavioral.visitor.newWay;

public class Wheel extends Part {

    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
