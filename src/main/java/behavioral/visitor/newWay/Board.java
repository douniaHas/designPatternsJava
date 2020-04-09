package behavioral.visitor.newWay;

public class Board extends Part {
    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
