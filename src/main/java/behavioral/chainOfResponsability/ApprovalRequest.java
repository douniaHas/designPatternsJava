package behavioral.chainOfResponsability;

public class ApprovalRequest {
    private Type type;
    private Integer amount;

    public ApprovalRequest(Type type, Integer amount) {
        this.type = type;
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public Integer getAmount() {
        return amount;
    }
}
