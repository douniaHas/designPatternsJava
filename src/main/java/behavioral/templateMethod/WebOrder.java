package behavioral.templateMethod;

public class WebOrder extends TemplateMethod {

    public WebOrder(boolean gift) {
        setGift(gift);
    }

    @Override
    protected void printReceipt() {
        System.out.println("receipt printed");
    }

    @Override
    protected void wrapGift() {
        System.out.println("gift wrapped");
    }

    @Override
    protected void pay() {
        System.out.println("order paid");
    }

    @Override
    protected void checkout() {
        System.out.println("checkout done");
    }
}
