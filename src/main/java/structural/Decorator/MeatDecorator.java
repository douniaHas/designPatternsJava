package structural.Decorator;

public class MeatDecorator extends SandwichDecorator {
    private Sandwich customSandwich;

    public MeatDecorator(Sandwich customSandwich) {
        this.customSandwich = customSandwich;
    }

    @Override
    public String make(){
        return "meat " + customSandwich.make();
    }
}
