package behavioral;

import behavioral.chainOfResponsability.ApprovalRequest;
import behavioral.chainOfResponsability.CEO;
import behavioral.chainOfResponsability.Director;
import behavioral.chainOfResponsability.VP;
import org.junit.Test;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static behavioral.chainOfResponsability.Type.CONFERENCE;
import static behavioral.chainOfResponsability.Type.PURCHASE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChainOfResponsabilityTest {

    private final Logger logger = Logger.getLogger(ChainOfResponsabilityTest.class.getName());

    @Test
    public void should_not_log_finest(){//TODO: How to prove with assert?
        logger.setLevel(Level.FINER);
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.FINER);
        logger.addHandler(handler);

        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    @Test
    public void should_get_an_approval_from_the_director_for_conference(){
        Director director = new Director();
        VP VP = new VP();
        CEO CEO = new CEO();
        director.setSuccessor(VP);
        VP.setSuccessor(CEO);

        director.submitRequest(new ApprovalRequest(CONFERENCE, Integer.valueOf(2000)));

        assertTrue(director.getInCharge());
        assertFalse(VP.getInCharge());
        assertFalse(CEO.getInCharge());
    }
    @Test
    public void should_get_an_approval_from_the_VP_for_purchase_less_than_500(){
        Director director = new Director();
        VP VP = new VP();
        CEO CEO = new CEO();
        director.setSuccessor(VP);
        VP.setSuccessor(CEO);

        director.submitRequest(new ApprovalRequest(PURCHASE, Integer.valueOf(400)));

        assertFalse(director.getInCharge());
        assertTrue(VP.getInCharge());
        assertFalse(CEO.getInCharge());
    }

    @Test
    public void should_get_an_approval_from_the_CEO_for_purchase_of_15000(){
        Director director = new Director();
        VP VP = new VP();
        CEO CEO = new CEO();
        director.setSuccessor(VP);
        VP.setSuccessor(CEO);

        director.submitRequest(new ApprovalRequest(PURCHASE, Integer.valueOf(15000)));

        assertFalse(director.getInCharge());
        assertFalse(VP.getInCharge());
        assertTrue(CEO.getInCharge());
    }
}
