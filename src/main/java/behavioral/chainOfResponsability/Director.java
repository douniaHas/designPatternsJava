package behavioral.chainOfResponsability;

import static behavioral.chainOfResponsability.Type.CONFERENCE;

public class Director extends ApprovalHandler {

    private Boolean inCharge = false;

    @Override
    public void submitRequest(ApprovalRequest request) {
        if(CONFERENCE.equals(request.getType())){
            inCharge = true;
        }
        else {
            successor.submitRequest(request);
        }
    }

    public Boolean getInCharge() {
        return inCharge;
    }
}
