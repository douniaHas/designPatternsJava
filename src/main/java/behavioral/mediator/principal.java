package behavioral.mediator;

import java.util.Timer;
import java.util.TimerTask;

public class principal {

    public static void main(String... args) {
        System.out.println("hello !! ");

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

        timer.schedule(hello, 1000);
        timer.schedule(bye, 5000);
    }
}
