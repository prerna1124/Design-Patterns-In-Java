package in.innoskrit.designpatterns.creational.singleton;

import java.io.*;
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

    public static void main(String[] args) throws IOException, ClassNotFoundException {

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

    }
}
