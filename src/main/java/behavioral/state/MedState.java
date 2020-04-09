package behavioral.state;

public class MedState implements State {
    private Fan fan;

    public MedState(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void handleRequest() {
        System.out.println("low state goes low");
        fan.setState(fan.getLowState());
    }
}
