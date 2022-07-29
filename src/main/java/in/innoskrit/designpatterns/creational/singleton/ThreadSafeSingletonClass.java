package in.innoskrit.designpatterns.creational.singleton;

public class ThreadSafeSingletonClass {

    private static ThreadSafeSingletonClass singletonClassInstance;

    private ThreadSafeSingletonClass() {

    }

    public static synchronized ThreadSafeSingletonClass getInstance() {
        if(singletonClassInstance == null) {
            singletonClassInstance = new ThreadSafeSingletonClass();
        }
        return singletonClassInstance;
    }
}
