package behavioral.chainOfResponsability;

public abstract class ApprovalHandler {

    ApprovalHandler successor;

    public void setSuccessor(ApprovalHandler successor){
        this.successor = successor;
    }

    public abstract void submitRequest(ApprovalRequest request);
}
