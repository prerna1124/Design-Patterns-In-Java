package in.innoskrit.designpatterns.creational.singleton;

public class Driver {

    public static void main(String[] args) {

        // Testing SingletonClass
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2 = SingletonClass.getInstance();
        System.out.println(instance1 == instance2);

        // Testing SingletonClassEagerInitialization
        SingletonClassEagerInitialization instance3 = SingletonClassEagerInitialization.getInstance();
        SingletonClassEagerInitialization instance4 = SingletonClassEagerInitialization.getInstance();
        System.out.println(instance3 == instance4);

        // Testing SingletonClassStaticBlockInitialization
        SingletonClassStaticBlockInitialization instance5 = SingletonClassStaticBlockInitialization.getInstance();
        SingletonClassStaticBlockInitialization instance6 = SingletonClassStaticBlockInitialization.getInstance();
        System.out.println(instance5 == instance6);

        // Testing ThreadSafeSingletonClass
        ThreadSafeSingletonClass instance7 = ThreadSafeSingletonClass.getInstance();
        ThreadSafeSingletonClass instance8 = ThreadSafeSingletonClass.getInstance();
        System.out.println(instance7 == instance8);



    }
}
