package creational.abstractFactory;

public class VisaCardFactory extends CreditCardFactory{

    @Override
    public CreditCard getCard(String type){
        switch (type){
            case "GOLD" : return new CreditCard(false);
            case "PLATINUM" : return new CreditCard(true);
            default: return null;
        }
    }
}
