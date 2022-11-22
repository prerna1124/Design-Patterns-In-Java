package in.innoskrit.designpatterns.creational.singleton;

import java.io.Serializable;

public class SingletonClassWithSerialization implements Serializable {

    private static volatile SingletonClassWithSerialization singletonClassInstance;

    private SingletonClassWithSerialization() {

    }

    public static SingletonClassWithSerialization getInstance() {
        if(singletonClassInstance == null) {
            synchronized (SingletonClassWithSerialization.class) {
                if (singletonClassInstance == null) {
                    singletonClassInstance = new SingletonClassWithSerialization();
                }
            }
        }
        return singletonClassInstance;
    }

    /**
     * This method is internally called by ObjectInputStream while deserialization.
     * @return singletonClassInstance   the Singleton Class Instance
     */
    public Object readResolve() {
        return singletonClassInstance;
    }
}
