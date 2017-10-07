package java8;

/**
 *
 * @author Kishan
 */

/*
 Introduction :

 In the Java programming language, an interface is a reference type, similar to a class, 
 that can contain only constants, method signatures, static methods, and nested types.

 Method in an Interface does not have a body, and they are implicitly public abstract by default.

 Wait, Above defination of interface was correct upto java 7. In java 8 release, Defination of interface is a bit broader then previous one.

 From java 8, Interface can have default methods also.

 What is Default Method ?

 The method with default implementation in interface are Default methods, they can have body part also and these are non-abstract methods.
 These methods are useful to provide default implementations and can be inherited in the class which implements the interface.
 and it can be Overridden also.

 You specify that a method definition in an interface is a default method with the default keyword at the beginning of the method signature.
 All method declarations in an interface, including default methods, are implicitly public, so you can omit the public modifier.

 Why Default method ?

 Suppose at some point you want to add new functionality in declared interface,
 Upto java 7, If you will add a new method in declared HasBody interface, you also have to define the implementatnion of the method in classes that are implementing HasBody interface.
 In java 8, You can add a default method containing the implementation of method and all the child class will inherit that method.

In java 8, Bulk data operation in collection is added (Reference : http://openjdk.java.net/jeps/107), to implement that forEach method is added in Collection interface.
If we are adding abstract method in Collection interface, that will break all the existing code because each class has to implement that method.
Solving the issue, following default forEach method is added in Collection interface

interface Collection<T> {
    default void forEach(Block<T> action) {
        for (T t : this)
        action.apply(t);
    }
}

Example of default method : 
*/
interface HasBody {

    default void first() {
        System.out.println("This is first default method in HasBody interface.");
    }

    default void second() {
        System.out.println("This is second default method in HasBody interface.");
    }

    void third();
}

class Demo implements HasBody {

    @Override
    public void second() {
        System.out.println("Overriding default method in child class.");
    }

    @Override
    public void third() {
        System.out.println("This is implemented abstract method of an interface.");
    }

    public void implement() {
        HasBody ref = new Demo();
        // Calling first() default method declared in HasBody interface.
        ref.first();

        // Calling Overridden default method of HasBody interface.
        ref.second();

        // Calling implemented method of HasBody interface.
        ref.third();
    }
}

/*
 In above example, there are three scenerios,
 first() method is default method in HasBody interface and inherited in DefaultMethodDemo class.
 second() method is default method in HasBody interface and Overridden in DefaultMethodDemo class.
 third() method is abstract method in HasBody interface and Implemented in DefaultMethodDemo class.

 Multiple inheritance :

 As the default methods in interface will be inherited in class that will implement interface
 and a class can implement more than one interface that may contain same method that defined default in interface.
 Multiple inheritance will be into the picture and because of that, ambiguity may be created.

 Well, this situatiuon is handled compile time in JDK 8
 Example :

 */

interface CreateAmbiguityOne {

    default void abc() {
        System.out.println("This method will create ambiguity.");
    }
}

interface CreateAmbiguityTwo {

    default void abc() {
        System.out.println("This method will create ambiguity.");
    }
}

/*
 class AmbiguousChild implements CreateAmbiguityOne,CreateAmbiguityTwo {
 // Ambiguouity in class.
 }

 Above code will not compile, Error will be 
 class Child inherits unrelated default for abc() from types CreateAmbiguityOn and CreateAmbiguityTwo.

 By overriding abc method in Child class will solve above ambiguity.
 */
class Child implements CreateAmbiguityOne, CreateAmbiguityTwo {

    @Override
    public void abc() {
        System.out.println("Overriding abc() will solve Ambiguity.");
    }
}

/*
 Another point to note is extending a class that contains same method as default method in interface will not create ambiguity.
 because Child class will Override the default method of interface by inherited method of parent class.

 Example :
 */
class Parent {

    public void abc() {
        System.out.println("This method will override default method of interface in child class.");
    }
}

class ChildTwo extends Parent implements CreateAmbiguityOne {
    // This class has no ambiguity even if Parent class and CreateAmbiguityOne has same method.
    // Because,
    // Inherited abc() method of Parent class will Override default method of CreateAmbiguityOne in ChildTwo class.
}

/*
 Behavior of default method when we extend interface.

All the default methods of interface will be inherited in child interface.
Child interface can override the default method.
Child interface can declare default method of parent interface as abstract, that will force implementing class to Override the default method.

 */
interface ChildInter extends HasBody {
    // All the default methods of HasBody interface will be inherited here.
    
    // Override the default method in child interface.
    default void first() {
        System.out.println("first() method is overriden in child interface.");
    }
    
    // Redefine the default method as abstract that will force subclass to Override the method.
    abstract void second();
}

class DemoTwo implements ChildInter {

    @Override
    public void second() {
        System.out.println("Subclass overriding default method of HasBody interface redefined in ChildInter.");
    }

    @Override
    public void third() {
        System.out.println("abstract method of HasBody interface.");
    }
}

public class DefaultMethodDemo {

    public static void main(String[] args) {
        new Demo().implement();
    }
}