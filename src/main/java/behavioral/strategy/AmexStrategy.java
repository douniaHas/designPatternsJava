package behavioral.strategy;

public class AmexStrategy extends Strategy {

    @Override
    boolean isValid(CreditCard creditCard) {
        return creditCard.getNumber() > 100100 && creditCard.getExpiryDate()!=null;
    }
}
