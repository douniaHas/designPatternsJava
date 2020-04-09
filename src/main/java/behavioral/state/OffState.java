package behavioral.state;

public class OffState implements State {
    private Fan fan;

    public OffState(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void handleRequest() {
        System.out.println("low state goes med");
        fan.setState(fan.getMedState());
    }
}
