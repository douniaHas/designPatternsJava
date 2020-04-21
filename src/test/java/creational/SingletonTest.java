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
    public void should_not_enable_getting_another_instance_using_reflection() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, OperationNotSupportedException, NoPermissionException {
        DbSingleton.getInstance();
        try {
            Constructor<DbSingleton> constructor = DbSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }
        catch(Exception e){
            assertEquals("You have to call getInstance()",((InvocationTargetException) e).getTargetException().getMessage());
        }
    }

    private class SingletonThread implements Runnable{
        DbSingleton instance;
        @Override
        public void run() {
            try {
                instance = DbSingleton.getInstance();
            } catch (NoPermissionException e) {
                Assert.fail();
            }
        }
    }

    /*
    To test and compare between the failing test and the succeeding one and
    understand why we added synchronized you can comment the code that is synchronized in DbSingleton class
    If you do so, the test will fail.
     */
    @Test
    public void should_get_a_singleton_instance (){
        SingletonThread thread1 = new SingletonThread();
        SingletonThread thread2 = new SingletonThread();
        List<SingletonThread> threads = Arrays.asList(thread1,thread2);

        threads.parallelStream().forEach(t->t.run());
    }
}
