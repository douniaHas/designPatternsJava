package creational.singleton;

import javax.naming.NoPermissionException;
import javax.naming.OperationNotSupportedException;
import java.util.Date;

/* one instance of DbSingletonSimple */
public class DbSingleton {
    //static to make getInstance accessible without new (which is private)
    public static DbSingleton getInstance() throws OperationNotSupportedException, NoPermissionException {

        //lazy loading
        if(instance == null){
            /*
            //one occurence even if multi-threated context
            synchronized (DbSingleton.class){
                //TODO : not understood
                if(instance == null){
                    instance = new DbSingleton();
                }
            }
             */
            instance = new DbSingleton();
            System.out.println("got " + instance + " at time " + new Date().getTime());
        }
        System.out.println("got " + instance + " at time " + new Date().getTime());
        return instance;
    }

    //always last-occurence in multi-threated context
    //private static volatile DbSingleton instance = null;
    private static DbSingleton instance = null;

    private DbSingleton() throws NoPermissionException {
        if(instance != null) {
            throw new NoPermissionException("You have to call getInstance()");
        }
    };

}
