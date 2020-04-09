package creational.singleton;

/* one instance of DbSingletonSimple */
public class DbSingleton {
    //static to make getInstance accessible without new (which is private)
    public static DbSingleton getInstance() {
        //lazy loading
        if(instance == null){
            //one occurence even if multi-threated context
            synchronized (DbSingleton.class){
                //TODO : not understood
                if(instance == null){
                    instance = new DbSingleton();
                }
            }
        }
        return instance;
    }

    //always last-occurence in multi-threated context
    private static volatile DbSingleton instance = null;

    private DbSingleton(){
        //forbid use of reflexion to get instance
        if(instance != null){
            throw new RuntimeException("You have to call getInstance()");
        }
    };

}
