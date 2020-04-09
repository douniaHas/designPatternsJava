package behavioral;

import behavioral.Interpreter.AndExpression;
import behavioral.Interpreter.Expression;
import behavioral.Interpreter.OrExpression;
import behavioral.Interpreter.TerminalExpression;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InterpreterTest {

    @Test
    public void find_bear_lion_and_tiger_in_sentence(){
        Pattern pattern = Pattern.compile("lion|bear|tiger");
        Matcher matcher = pattern.matcher("This is the zoo where a bear and a tiger can be found");

        while(matcher.find()){
            System.out.println(matcher.group() + " found");
        }
    }

    @Test
    public void should_find_lions_from_lions(){
        String sentence = "lions";
        Expression e = buildSingleExpression(sentence);

        assertTrue(e.interpret("lions"));
    }

    @Test
    public void should_find_lions_from_lions_and_bears(){
        String sentence = "lions and bears";
        Expression e = buildSingleExpression(sentence);

        assertTrue(e.interpret("lions"));
    }

    @Test
    public void should_not_find_tigers_from_lions_and_bears(){
        String sentence = "lions and bears";
        Expression e = buildSingleExpression(sentence);

        assertFalse(e.interpret("tigers"));
    }

    @Test
    public void should_not_find_tigers_lions_from_lions_and_bears(){
        String sentence = "lions and bears";
        Expression e = buildComplexExpression(sentence);

        assertFalse(e.interpret("tigers"));
    }

    private Expression buildComplexExpression(String sentence) {
        return new AndExpression(buildSingleExpression(sentence)
                , new OrExpression(
                        buildSingleExpression("tiger"),
                buildSingleExpression("lions")));
    }

    private Expression buildSingleExpression(String sentence) {
        return new TerminalExpression(sentence);
    }
}
