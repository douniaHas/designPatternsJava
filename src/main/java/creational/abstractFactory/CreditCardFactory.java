package creational.abstractFactory;

public abstract class CreditCardFactory {

    public static CreditCardFactory create(int points){
        if(points > 500) {
            return new AmexCardFactory();
        }
        else {
            return new VisaCardFactory();
        }
    }

    public abstract CreditCard getCard(String type);
}
