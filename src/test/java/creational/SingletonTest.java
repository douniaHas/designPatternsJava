package creational;

import creational.singleton.DbSingleton;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.NoPermissionException;
import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import static creational.singleton.DbSingleton.getInstance;
import static org.junit.Assert.assertEquals;

/**
 * One and unique instance of the class
 * Static to be accessible everywhere
 * Lazy loading : The instance is not loaded at the beginning of the program but on demand
 * One instance even if multi-threaded context
 * always get last occurrence in multi-threaded context ?
 * use of reflexion to get the instance is forbidden
 */
public class SingletonTest {

    @Test
    public void should_runtime_be_singleton(){
        Runtime instance1 = Runtime.getRuntime();
        Runtime instance2 = Runtime.getRuntime();

        assertEquals(instance1, instance2);
    }

    @Test
    public void should_string_not_be_a_singleton(){
        String mot1 = "abc";
        String mot2 = "def";

        Assert.assertNotEquals(mot1, mot2);
    }

    @Test
    public void should_not_enable_getting_another_instance_by_using_reflection() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, OperationNotSupportedException, NoPermissionException {
        getInstance();
        try {
            Constructor<DbSingleton> constructor = DbSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }
        catch(Exception e){
            assertEquals("You have to call getInstance()",((InvocationTargetException) e).getTargetException().getMessage());
        }
    }

    @Test
    public void should_get_a_singleton_instance (){
        Thread thread1 = new Thread(new Runnable() {
            DbSingleton instance1;
            @Override
            public void run() {
                try {
                    instance1 = getInstance();
                } catch (OperationNotSupportedException | NoPermissionException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            DbSingleton instance2;
            @Override
            public void run() {
                try {
                    instance2 = getInstance();
                } catch (OperationNotSupportedException | NoPermissionException e) {
                    e.printStackTrace();
                }
            }
        });
        List<Thread> threads = Arrays.asList(thread1,thread2);
        threads.parallelStream().forEach(t->t.run());
    }

    @Test//TODO : parallel test issues..
    public void should_time_be_zero_for_getting_instance_for_at_least_second_time() throws OperationNotSupportedException, NoPermissionException {
        long timeBeforeInstance1 = System.currentTimeMillis();
        DbSingleton instance1 = getInstance();
        long timeAfterInstance1 = System.currentTimeMillis();
        DbSingleton instance2 = getInstance();
        long timeAfterInstance2 = System.currentTimeMillis();

        //Assert.assertEquals(0,timeAfterInstance2-timeAfterInstance1);
        assertEquals(0,timeAfterInstance2-timeAfterInstance1);
    }
}
