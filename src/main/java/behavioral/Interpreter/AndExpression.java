package behavioral.Interpreter;

public class AndExpression implements Expression {


    private final Expression ExpressionA;
    private final Expression ExpressionB;


    public AndExpression(Expression ExpressionA, Expression ExpressionB) {
        this.ExpressionA = ExpressionA;
        this.ExpressionB = ExpressionB; 
    }

    @Override
    public boolean interpret(String message) {
        return ExpressionA.interpret(message) && ExpressionB.interpret(message);
    }
}
