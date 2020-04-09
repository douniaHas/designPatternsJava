package behavioral.Interpreter;

import java.util.StringTokenizer;

public class TerminalExpression implements Expression {

    private final String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String message) {
        StringTokenizer tokenizer = new StringTokenizer(data);
        while(tokenizer.hasMoreTokens()){
            String s = tokenizer.nextToken();
            if(s.equals(message)){
                return true;
            }
        }
        return false;
    }
}
