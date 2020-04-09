package structural.adapter;

public class EmployeeFromMyApp implements Employee {

    private String id;
    private String firstName;
    private String lastName;

    public EmployeeFromMyApp(String id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }
}
