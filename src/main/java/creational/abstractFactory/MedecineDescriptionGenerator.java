package creational.abstractFactory;

public class MedecineDescriptionGenerator extends DescriptionGenerator {
    @Override
    public Description getDescription(String description) {
        return new Description("Not yet specified");
    }
}
