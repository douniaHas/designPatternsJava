package behavioral;

import behavioral.strategy.AmexStrategy;
import behavioral.strategy.CreditCard;
import behavioral.strategy.VisaStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StrategyTest {

    @Test
    public void should_sort_by_age(){
        Employee ron = new Employee("ron", 76);
        Employee bris = new Employee("Bris", 31);
        List<Employee> employees = Arrays.asList(bris, ron);
        employees.sort(
                new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return o1.getAge() > o2.getAge()?1:-1;
                    }
                }
        );
        employees.stream().forEach(e -> System.out.println(e.getName()));
    }

    @Test
    public void should_sort_by_name(){
        Employee ron = new Employee("ron", 76);
        Employee bris = new Employee("Bris", 31);
        List<Employee> employees = Arrays.asList(bris, ron);
        employees.sort(
                new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return o1.getName() .compareTo(o2.getName());
                    }
                }
        );
        employees.stream().forEach(e -> System.out.println(e.getName()));
    }

    @Test//TODO : replace String date by Date !
    public void should_validate_amex_credit_card(){
        CreditCard amex = new CreditCard(123456789, "01-02-2021", new AmexStrategy());
        Assert.assertTrue(amex.isValid());
    }

    @Test
    public void should_not_validate_visa_credit_card(){
        CreditCard visa = new CreditCard(123456789, "01-02-2021", new VisaStrategy());
        Assert.assertFalse(visa.isValid());
    }

    private class Employee {

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
    }
}
