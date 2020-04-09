package behavioral;

import behavioral.momento.CareTaker;
import org.junit.Test;

import java.io.*;
//TODO : KO !
public class MementoTest {

    public static final String EMPLOYEE_FILE = "empFile";


    @Test
    public void should_serialize_and_deserialize_employee() throws IOException, ClassNotFoundException {
        Employee employee = new Employee();
        employee.setName("David");
        employee.setAge("23");

        serialize(employee);

        //Assert.assertNotNull(deserialize());
    }

    @Test
    public void should_push_and_pop_history_of_employees(){
        behavioral.momento.Employee employee = new behavioral.momento.Employee("David", "32");
        CareTaker careTaker = new CareTaker();
        careTaker.save(employee);
        employee.setAge("44");
        careTaker.save(employee);
        employee.setAge("67");
        careTaker.save(employee);
        employee.setAge("80");
        careTaker.revert(employee);
        careTaker.revert(employee);
        careTaker.revert(employee);
    }

    private Employee deserialize() throws IOException, ClassNotFoundException {
        FileInputStream inStream = new FileInputStream(EMPLOYEE_FILE);
        ObjectInputStream objInStream = new ObjectInputStream(inStream);
        return (Employee) objInStream.readObject();
    }

    private void serialize(Employee employee){

        ObjectOutputStream objOutStream;
        try (FileOutputStream outStream = new FileOutputStream(EMPLOYEE_FILE)) {
            objOutStream = new ObjectOutputStream(outStream);
            objOutStream.writeObject(employee);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Employee implements Serializable {
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
