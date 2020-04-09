package behavioral.templateMethod;

public abstract class TemplateMethod {

    private boolean isGift;

    public final void setGift(boolean gift) {
        isGift = gift;
    }

    public final void process(){
        checkout();
        pay();
        if(isGift){
            wrapGift();
        }
        printReceipt(); 
    }

    protected abstract void printReceipt();

    protected abstract void wrapGift();

    protected abstract void pay();

    protected abstract void checkout();
}
