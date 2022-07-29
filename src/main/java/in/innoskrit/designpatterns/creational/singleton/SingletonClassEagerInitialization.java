package in.innoskrit.designpatterns.creational.singleton;

public class SingletonClassEagerInitialization {

    private static SingletonClassEagerInitialization singletonClassInstance = new SingletonClassEagerInitialization();

    private SingletonClassEagerInitialization() {

    }

    public static SingletonClassEagerInitialization getInstance() {
        return singletonClassInstance;
    }

}
