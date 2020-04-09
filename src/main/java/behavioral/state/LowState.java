package behavioral.state;



public class LowState implements State {
    private Fan fan;

    public LowState(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void handleRequest() {
        System.out.println("low state goes off");
        fan.setState(fan.getOffState());
    }
}
