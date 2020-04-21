package creational.singleton;

import javax.naming.NoPermissionException;

public class DbSingleton {
    public static DbSingleton getInstance() throws NoPermissionException {
        if(instance == null){
            synchronized (DbSingleton.class){
                if(instance == null){
                    instance = new DbSingleton();
                }
            }
        }
        return instance;
    }

    //always last-occurence in multi-threated context ; there is only one occurence, why it is needed ?
    private static volatile DbSingleton instance = null;

    private DbSingleton() throws NoPermissionException {
        if(instance != null) {
            throw new NoPermissionException("You have to call getInstance()");
        }
    };

}
