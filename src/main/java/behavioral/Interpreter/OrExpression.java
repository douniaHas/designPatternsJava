package behavioral.Interpreter;

public class OrExpression implements Expression {
    private final Expression ExpressionA;
    private final Expression ExpressionB;


    public OrExpression(Expression ExpressionA, Expression ExpressionB) {
        this.ExpressionA = ExpressionA;
        this.ExpressionB = ExpressionB;
    }

    @Override
    public boolean interpret(String message) {
        return ExpressionA.interpret(message) || ExpressionB.interpret(message);
    }
}
