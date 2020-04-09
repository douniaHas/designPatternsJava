package behavioral.momento;

import java.util.Stack;

public class CareTaker {

    Stack<EmployeeMomento> history = new Stack<>();

    public void save(Employee employee){
        history.push(employee.save());
        System.out.println(employee.getName()+" age "+employee.getAge());
    }

    public void revert(Employee employee){
        Employee result = employee.revert(history.pop());
        System.out.println(result.getName()+" age "+employee.getAge());
    }
}
