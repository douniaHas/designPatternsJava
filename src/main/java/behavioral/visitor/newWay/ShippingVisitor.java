package behavioral.visitor.newWay;

public class ShippingVisitor extends Visitor{
    private long shippingAmount = 0;

    @Override
    public void visit(Oil oil) {
        System.out.println("shipping oil ");
        shippingAmount += 20;
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.println("shipping wheel ");
        shippingAmount += 20;
    }

    @Override
    public void visit(Board board) {
        System.out.println("shipping board ");
        shippingAmount += 0;
    }

    @Override
    public void visit(Vehicle vehicle) {
        System.out.println("shipping vehicle ");
        if(vehicle.getParts().size() >= 3){
            System.out.println("discount on shipping fee ");
            shippingAmount -= 5;
        }
    }
}
