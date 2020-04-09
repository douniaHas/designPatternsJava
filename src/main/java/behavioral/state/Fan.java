package behavioral.state;

public class Fan {

    private State state;
    private State offState;
    private State lowState;
    private State medState;

    public Fan() {
        offState = new OffState(this);
        lowState = new LowState(this);
        medState = new MedState(this);

        state = lowState;
    }

    public void pullChain(){
       state.handleRequest();
    }

    public void print(){
        System.out.println(state);
    }

    public State getOffState() {
        return offState;
    }
    public State getLowState() {
        return lowState;
    }
    public State getMedState() {
        return medState;
    }
    public void setState(State state) {
        this.state = state;
    }

}
