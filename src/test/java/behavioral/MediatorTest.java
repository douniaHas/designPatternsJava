package behavioral;

import behavioral.command.Light;
import behavioral.mediator.LightMediator;
import behavioral.mediator.TurnAllLightsOffCommand;
import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

public class MediatorTest {
    //TODO : marche pas pcq dans TU
    @Test//TODO : sysout -> assert
    public void should_greet() throws InterruptedException {
        Timer timer = new Timer();
        //new Thread().sleep(11000);

        class HelloTask extends TimerTask {
            @Override
            public void run() {
                System.out.println("say hello ! ");
            }
        }
        TimerTask hello = new HelloTask();

        class GoodbyeTask extends TimerTask {
            @Override
            public void run() {
                System.out.println("say goodbye ! ");
            }
        };
        TimerTask bye = new GoodbyeTask();

        timer.schedule(hello, 10000);
        timer.schedule(bye, 50000);
    }

    @Test
    public void should_turn_all_lights_off_calling_a_mediator(){
        LightMediator mediator = new LightMediator();
        Light bedroomLight = new Light();
        bedroomLight.on();
        Light kitchenLight = new Light();

        mediator.registerLight(bedroomLight);
        mediator.registerLight(kitchenLight);

        TurnAllLightsOffCommand command = new TurnAllLightsOffCommand(mediator);
        command.execute();
    }
}
