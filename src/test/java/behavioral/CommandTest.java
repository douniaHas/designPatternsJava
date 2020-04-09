package behavioral;

import behavioral.command.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CommandTest {

    @Test
    public void should_execute_runnable_tasks(){
        Task task = new Task(2,3);

        task.run();

        Assert.assertEquals(5, task.getResult().intValue());
    }

    @Test
    public void should_execute_command_on_light(){
        Switch switcher = new Switch();
        Light light = new Light();
        switcher.execute(new OnCommand(light));
    }

    @Test
    public void should_toggle_light(){
        Switch switcher = new Switch();
        Light light = new Light();

        switcher.execute(new ToggleCommand(light));
        switcher.execute(new ToggleCommand(light));
        switcher.execute(new ToggleCommand(light));
    }

    @Test
    public void toggle_all_lights_off_when_no_one_is_on(){
        Switch switcher = new Switch();
        Light bedroomLight = new Light();
        Light kitchenLight = new Light();

        switcher.execute(new ToggleAllCommand(Arrays.asList(bedroomLight, kitchenLight)));
    }

    @Test
    public void toggle_all_lights_off_when_bedroom_light_is_already_on(){
        Switch switcher = new Switch();
        Light bedroomLight = new Light();
        Light kitchenLight = new Light();

        switcher.execute(new ToggleCommand(kitchenLight));

        switcher.execute(new ToggleAllCommand(Arrays.asList(bedroomLight, kitchenLight)));
    }

    private class Task implements Runnable{
        private Integer first;
        private Integer second;
        private Integer result;

        public Integer getResult() {
            return result;
        }

        public Task(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public void run() {
            this.result = first + second;
        }
    }
}
