package in.innoskrit.designpatterns.creational.singleton;

public class ThreadSafeSingletonClass {

    private static volatile ThreadSafeSingletonClass singletonClassInstance;

    private ThreadSafeSingletonClass() {

    }

    /**
     * This is one way to make this method thread safe with the use of synchronized keyword.
     * @return singletonClassInstance   the singleton class instance
     */
    public static synchronized ThreadSafeSingletonClass getInstance() {
        if(singletonClassInstance == null) {
            singletonClassInstance = new ThreadSafeSingletonClass();
        }
        return singletonClassInstance;
    }

    /**
     * This is another way to make this method thread safe with the use of synchronized block.
     * @return singletonClassInstance   the singleton class instance
     */
    public static ThreadSafeSingletonClass getInstance2() {
        if(singletonClassInstance == null) {
            synchronized (ThreadSafeSingletonClass.class) {
                if (singletonClassInstance == null) {
                    singletonClassInstance = new ThreadSafeSingletonClass();
                }
            }
        }
        return singletonClassInstance;
    }
}
