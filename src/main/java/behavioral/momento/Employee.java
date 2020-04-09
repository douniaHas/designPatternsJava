package behavioral.momento;

public class Employee {
    private String name;
    private String age;


    public Employee(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public EmployeeMomento save(){
        return new EmployeeMomento(name, age);
    }

    public Employee revert(EmployeeMomento employeeMomento){
        this.name = employeeMomento.getName();
        this.age = employeeMomento.getAge();
        return this;
    }

}
