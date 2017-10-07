package java8;

/**
 *
 * @author Kishan Sarsecha
 */

/*
 Method reference :

 In previous article about Lambda Expression, we explaind how to use anonymous methods.
 Before moving forward, It is recommended to take a look at Lambda Expressions in java if you are new to Java 8.

 Some times, A lambda expression do nothing but just calls a method which is already defined.
 In this case, to be more lazy to write, You can use method references.

 Method references are just compact and more readable form of a lambda expression for already written methods.

 Example :
 */
// Don't forget Functional interfaces are heart of labmda expression.
interface IsReferable {
    public void referenceDemo();
}

class ReferenceDemo {

    public static void commonMethod() {
        System.out.println("This method is already defined.");
    }

    public void implement() {

        // Anonymous class.
        IsReferable demoOne = new IsReferable() {
            @Override
            public void referenceDemo() {
                ReferenceDemo.commonMethod();
            }
        };
        demoOne.referenceDemo();

        // Lambda implementaion.
        IsReferable demo = () -> ReferenceDemo.commonMethod();
        demo.referenceDemo();

        // Method reference.
        IsReferable demoTwo = ReferenceDemo::commonMethod;
        demoTwo.referenceDemo();
    }
}

/*
 In above example, all three implementations, 1) using anonymous class 2) Lambda Expression and 3)Method reference will give same results.
 Anonymous class implementation is added to provide redability.

 So a method reference will call the method mentioned right side of "::" from the body of implemented only abstract method of Functional interface.

 When to use :
    When a Lambda expression is invoking already defined method, you can replace it with reference to that method.

 When you can not use Method reference :
    You can not pass arguments to the method reference.
    for example, you can not use method reference for following lambda.
    IsReferable demo = () -> ReferenceDemo.commonMethod("Argument in method.");
    Because Java does not support curring without Wrapper methods or Lambda.
    https://en.wikipedia.org/wiki/Currying

Kind of method references :
 As mentioned in the Javadoc, there are four kind of Method references.
 
Reference to a static method : ClassName::staticMethod
Example : ReferenceDemo::commonMethod
where ReferenceDemo is class in which static method commonMethod defined.

Reference to an instance method of a particular object : ObjectOfClass::instanceMethod
Example :  demo::anotherMethod
Where demo is and object reference for ReferenceDemo class and anotherMethod is instance method defined in class.

Reference to an instance method of an arbitrary object of a particular type : ContainingType::methodName
Example : String::compareToIgnoreCase
Method for and perticular arbitary object type like String, Integer etc...

Reference to a constructor : ClassName::new
Example : String::new 
which is reference to the String class constructor.

So, Method reference is smaller feature of java 8 comare to gigentic Lambda and other cool features.
Useful Links : 
http://www.java8.in/java-8-lambda-expression/
http://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html

Query posted on stackoverflow before writing this article.
http://stackoverflow.com/q/23022939/1686291

You can always clone the executable code of article posted on Java By Examples from github.com 
Repository URL : https://github.com/ksarsecha/java8_in.git

 */

public class MethodReferenceDemo {

    public static void main(String[] args) {
        ReferenceDemo demo = new ReferenceDemo();
        demo.implement();
    }
}
