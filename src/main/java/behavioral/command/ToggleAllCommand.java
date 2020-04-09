package behavioral.command;

import java.util.List;

public class ToggleAllCommand implements Command {


    private final List<Light> lights;

    public ToggleAllCommand(List<Light> lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        for (Light light:lights
        ) {
            if(light.isOn()){
                new ToggleCommand(light).execute();
            }
        }
    }
}
