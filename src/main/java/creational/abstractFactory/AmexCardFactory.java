package creational.abstractFactory;

public class AmexCardFactory extends CreditCardFactory {

    @Override
    public CreditCard getCard(String type){
        switch (type){
            case "customer" : return new CreditCard(false);
            case "corporate" : return new CreditCard(true);
            default: return null;
        }
    }
}
