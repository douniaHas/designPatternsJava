package structural.Decorator;

public class DressingDecorator extends SandwichDecorator {
    private Sandwich customSandwich;

    public DressingDecorator(Sandwich customSandwich) {
        this.customSandwich = customSandwich;
    }

    @Override
    public String make(){
        return "mustard " + customSandwich.make();
    }
}
