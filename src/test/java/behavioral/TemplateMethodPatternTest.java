package behavioral;

import behavioral.templateMethod.TemplateMethod;
import behavioral.templateMethod.WebOrder;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TemplateMethodPatternTest {

    @Test
    public void should_sort_by_age(){
        Employee ron = new Employee("ron", 76);
        Employee bris = new Employee("Bris", 31);
        List<Employee> employees = Arrays.asList(bris, ron);
        Collections.sort(employees);
        employees.stream().forEach(e -> System.out.println(e.getName()));
    }

    @Test//TODO : how to check with assert without changing the prior code ??
    public void should_process_order_as_demanded_in_the_template_with_gift(){
        TemplateMethod webOrder = new WebOrder(true);
        webOrder.process();
    }

    @Test
    public void should_process_order_as_demanded_in_the_template_without_gift(){
        TemplateMethod webOrder = new WebOrder(false);
        webOrder.process();
    }

    private class Employee  implements Comparable<Employee>{

        private final String name;
        private final int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int compareTo(Employee o) {
            return age > o.getAge()?1:-1;
        }
    }
}
