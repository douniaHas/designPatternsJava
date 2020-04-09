package behavioral.visitor.newWay;

public abstract class Visitor {
    public abstract void visit(Oil oil);
    public abstract void visit(Wheel wheel);
    public abstract void visit(Board board);
    public abstract void visit(Vehicle vehicle);
}
