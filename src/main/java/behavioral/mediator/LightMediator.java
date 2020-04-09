package behavioral.mediator;

import behavioral.command.Light;

import java.util.ArrayList;
import java.util.List;

public class LightMediator {

    private List<Light> lights = new ArrayList<>();

    public List<Light> getLights() {
        return lights;
    }

    public void registerLight(Light light){
        lights.add(light);
    }


}
