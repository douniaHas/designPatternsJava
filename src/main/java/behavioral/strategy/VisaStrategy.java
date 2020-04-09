package behavioral.strategy;

public class VisaStrategy extends Strategy {
    @Override
    boolean isValid(CreditCard creditCard) {
        return false;
    }
}
