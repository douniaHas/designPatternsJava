package behavioral.visitor.newWay;

public class DisplayVisitor extends Visitor {
    @Override
    public void visit(Oil oil) {
        System.out.println("we got oil");
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.println("we got wheel");
    }

    @Override
    public void visit(Board board) {
        System.out.println("we got board");
    }

    @Override
    public void visit(Vehicle vehicle) {
        System.out.println("we got vehicle");
    }
}
