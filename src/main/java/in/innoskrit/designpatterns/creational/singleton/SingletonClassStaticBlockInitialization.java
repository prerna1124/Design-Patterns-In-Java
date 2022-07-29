package in.innoskrit.designpatterns.creational.singleton;

public class SingletonClassStaticBlockInitialization {

    public static SingletonClassStaticBlockInitialization singletonClassInstance;

    static {
        singletonClassInstance = new SingletonClassStaticBlockInitialization();
    }

    private SingletonClassStaticBlockInitialization() {

    }

    public static SingletonClassStaticBlockInitialization getInstance() {
        return singletonClassInstance;
    }
}
