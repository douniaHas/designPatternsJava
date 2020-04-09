package behavioral.chainOfResponsability;

import static behavioral.chainOfResponsability.Type.PURCHASE;

public class CEO extends ApprovalHandler {

    private Boolean inCharge = false;

    @Override
    public void submitRequest(ApprovalRequest request) {
        if(PURCHASE.equals(request.getType()) && request.getAmount().intValue()>=500){
            inCharge = true;
        }
    }

    public Boolean getInCharge() {
        return inCharge;
    }
}
