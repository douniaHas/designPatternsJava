package behavioral;

import behavioral.state.Fan;
import org.junit.Test;

public class StateTest {

    @Test
    public void should_change_state_when_pull_chain_fan(){
        Fan fan = new Fan();
        fan.print();
        fan.pullChain();
        fan.print();
        fan.pullChain();
        fan.print();
        fan.pullChain();
        fan.print();
    }
}
