package in.innoskrit.designpatterns.creational.singleton;

/**
 * Rules to define the Singleton Class
 * 1. Declare the constructor of the class as private, so that no other class can call it.
 * 2. Declare a static method to create and return the instance of the Singleton Class.
 * 3. Declare a static member of the same class type which will hold the instance.
 *
 */
public class SingletonClass {

    private static SingletonClass singletonClassInstance;

    private SingletonClass() {

    }

    public static SingletonClass getInstance() {
        if(singletonClassInstance == null) {
            singletonClassInstance = new SingletonClass();
        }
        return singletonClassInstance;
    }
}
