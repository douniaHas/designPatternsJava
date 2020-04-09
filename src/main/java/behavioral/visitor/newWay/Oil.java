package behavioral.visitor.newWay;

public class Oil extends Part {
    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
