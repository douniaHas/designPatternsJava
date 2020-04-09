package structural.adapter;

public class CVSEmployeeToApp implements Employee {

    private final VCSEmployee instance;

    public CVSEmployeeToApp(VCSEmployee employee) {
        this.instance = employee;
    }

    @Override
    public String getId() {
        return instance.getId() + "";
    }

    @Override
    public String getFirstName() {
        return instance.getSurName();
    }

    @Override
    public String getLastName() {
        return instance.getUsualName();
    }
}
