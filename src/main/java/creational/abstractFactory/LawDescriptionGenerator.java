package creational.abstractFactory;

public class LawDescriptionGenerator extends DescriptionGenerator {
    @Override
    public Description getDescription(String description) {
        switch (description){
            case "professor" : return new Description("This is a law professor");
            case "lawyer" : return new Description("This is a lawyer");
        }
        return null;
    }
}
