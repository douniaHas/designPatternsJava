package structural;

import structural.adapter.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdapterTest {

    /**
     * A simple solution to deal with legacy code that we don't want/can't change
     * Transform an outer object into a well-known to work with
     * Doesn't need an interface, it'as just an example
     * Can adapt to multiple objects
     */
    @Test
    public void shouldAdaptArrayToList(){
        Integer ints[] = {1,2,3};
        List<Integer> IntsAsList = Arrays.asList(ints);

        Assert.assertTrue(IntsAsList.contains(1));
    }

    @Test
    public void shouldAdaptEmployeeDbToEmployee(){
        Employee employee = new EmployeeFromMyApp("123", "Loic", "Bertrand");
        EmployeeFromMyLegacyApp employeeFromMyLegacyApp = new EmployeeFromMyLegacyApp("456", "Guy", "Hance");
        Employee employeeAdaptedForMyApp = new EmployeeFromLegacyToMyApp(employeeFromMyLegacyApp);
        VCSEmployee CVSEMployee = new VCSEmployee(2, "Paul", "David");
        Employee employeeCSVAdaptedForMyApp = new CVSEmployeeToApp(CVSEMployee);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employeeAdaptedForMyApp);

        Assert.assertEquals("Guy", employeeAdaptedForMyApp.getFirstName());
        Assert.assertEquals("Paul", employeeCSVAdaptedForMyApp.getFirstName());
    }
}
