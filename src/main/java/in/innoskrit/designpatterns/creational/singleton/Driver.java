package in.innoskrit.designpatterns.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;

public class Driver {

    public static void testSingletonClass() {
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2 = SingletonClass.getInstance();
        System.out.println(instance1 == instance2);
    }

    public static void testSingletonClassEagerInitialization() {
        SingletonClassEagerInitialization instance1 = SingletonClassEagerInitialization.getInstance();
        SingletonClassEagerInitialization instance2 = SingletonClassEagerInitialization.getInstance();
        System.out.println(instance1 == instance2);
    }

    public static void testSingletonClassStaticBlockInitialization() {
        SingletonClassStaticBlockInitialization instance1 = SingletonClassStaticBlockInitialization.getInstance();
        SingletonClassStaticBlockInitialization instance2 = SingletonClassStaticBlockInitialization.getInstance();
        System.out.println(instance1 == instance2);
    }

    public static void testThreadSafeSingletonClass() {
        ThreadSafeSingletonClass instance1 = ThreadSafeSingletonClass.getInstance();
        ThreadSafeSingletonClass instance2 = ThreadSafeSingletonClass.getInstance();
        System.out.println(instance1 == instance2);
    }

    public static void testSingletonClassWithSerialization() throws IOException, ClassNotFoundException {
        SingletonClassWithSerialization instance1 = SingletonClassWithSerialization.getInstance();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(new File("/Users/prernasharma/Documents/Interview/designpatterns/utils/instance.ser").toPath()));
        objectOutputStream.writeObject(instance1);

        SingletonClassWithSerialization instance2 = null;
        ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(new File("/Users/prernasharma/Documents/Interview/designpatterns/utils/instance.ser").toPath()));
        instance2 = (SingletonClassWithSerialization) objectInputStream.readObject();

        objectInputStream.close();
        objectInputStream.close();

        System.out.println(instance1 == instance2);

    }

    /**
     * In this method, we are fetching all the constructors that are defined in the class, and we are making them accessible outside the class.
     * And then we are creating an instance and comparing the hash codes for both the instances. And as a result of which we are getting two
     * different instances created. Hence, it is breaking the rules of Singleton Class.
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void reflectionProblem() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        ThreadSafeSingletonClass instance1 = ThreadSafeSingletonClass.getInstance();
        ThreadSafeSingletonClass instance2 = null;

        Constructor[] constructors = ThreadSafeSingletonClass.class.getDeclaredConstructors();
        for (Constructor constructor: constructors) {
            constructor.setAccessible(true);
            try {
                instance2 = (ThreadSafeSingletonClass) constructor.newInstance();
                break;
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException exception) {
                exception.printStackTrace();
            }
        }
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // Testing SingletonClass
        Driver.testSingletonClass();

        // Testing SingletonClassEagerInitialization
        Driver.testSingletonClassEagerInitialization();

        // Testing SingletonClassStaticBlockInitialization
        Driver.testSingletonClassStaticBlockInitialization();

        // Testing ThreadSafeSingletonClass
        Driver.testThreadSafeSingletonClass();

        // Testing SingletonClassWithSerialization
        Driver.testSingletonClassWithSerialization();

        // Testing Reflection Problem
        Driver.reflectionProblem();

    }
}
