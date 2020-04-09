package behavioral.strategy;

public class CreditCard {
    private int number;
    private String expiryDate;
    private Strategy strategy;

    public CreditCard(int number, String expiryDate, Strategy strategy) {
        this.number = number;
        this.expiryDate = expiryDate;
        this.strategy = strategy;
    }

    public boolean isValid(){
        return strategy.isValid(this);
    }

    public int getNumber() {
        return number;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}
