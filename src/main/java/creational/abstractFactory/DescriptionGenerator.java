package creational.abstractFactory;

public abstract class DescriptionGenerator {

    public static DescriptionGenerator create(String field) {
        switch (field){
            case "medecine" : return new MedecineDescriptionGenerator();
            case "law" : return new LawDescriptionGenerator();
        }
        return null;
    }

    public abstract Description getDescription(String description);
}
