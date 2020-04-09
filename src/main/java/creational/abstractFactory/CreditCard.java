package creational.abstractFactory;

public class CreditCard {

    private String number;
    private boolean paid;

    public CreditCard(boolean paid){
        this.paid = paid;
    }

    public boolean isPaid() {
        return paid;
    }
}
