package creational;

import creational.singleton.DbSingleton;
import org.junit.Assert;
import org.junit.Test;

public class SingletonTest {

    @Test
    public void runtimeIsSingleton(){
        Runtime instance1 = Runtime.getRuntime();
        Runtime instance2 = Runtime.getRuntime();

        Assert.assertEquals(instance1, instance2);
    }

    @Test
    public void stringIsNotSingleton(){
        String mot1 = new String("abc");
        String mot2 = new String("def");

        Assert.assertNotEquals(mot1, mot2);
    }

    @Test
    public void should_get_a_singleton_instance(){
        DbSingleton instance1 = DbSingleton.getInstance();
        DbSingleton instance2 = DbSingleton.getInstance();
        Assert.assertEquals(instance1, instance2);
    }

    @Test//TODO : parallel test issues..
    public void should_time_be_zero_for_getting_instance_for_at_least_second_time(){
        long timeBeforeInstance1 = System.currentTimeMillis();
        DbSingleton instance1 = DbSingleton.getInstance();
        long timeAfterInstance1 = System.currentTimeMillis();
        DbSingleton instance2 = DbSingleton.getInstance();
        long timeAfterInstance2 = System.currentTimeMillis();

        //Assert.assertEquals(0,timeAfterInstance2-timeAfterInstance1);
        Assert.assertEquals(0,timeAfterInstance2-timeAfterInstance1);
    }
}
