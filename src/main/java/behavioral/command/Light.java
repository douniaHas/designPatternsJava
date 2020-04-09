package behavioral.command;

public class Light {

    private boolean on = false;

    public void on() {
        on = true;
    }

    public void off() {
        on = false;
    }

    public void toggle() {
        if (on) {
            System.out.println("off");
            off();
        } else {
            System.out.println("on");
            on();
        }
    }

    public boolean isOn() {
        return on;
    }
}
