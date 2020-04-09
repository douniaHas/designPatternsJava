package structural.adapter;

public class EmployeeFromLegacyToMyApp implements Employee{
    private EmployeeFromMyLegacyApp legacyAppEmp;

    public EmployeeFromLegacyToMyApp(EmployeeFromMyLegacyApp emp) {
        this.legacyAppEmp = emp;
    }

    @Override
    public String getId() {
        return legacyAppEmp.getId();
    }

    @Override
    public String getFirstName() {
        return legacyAppEmp.getFn();
    }

    @Override
    public String getLastName() {
        return legacyAppEmp.getLn();
    }
}
