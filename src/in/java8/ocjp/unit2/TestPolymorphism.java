package in.java8.ocjp.unit2;

/*
 * What is polymorphism ?
 * 	A java object that passes more than one IS-A test considered as polymorphic.
 * 	So, all the objects in except type Object are polymorphic as they passes IS-A test for own type and Object type. 
 * 	(Detailed reading : )
 * 
 * You are accessing a object stored in Heap by reference variable.
 * 	A reference variable type of class can reference object of any subtype of that class.
 * 	For example,
 */

class Animal {
	public void name() {
		System.out.println("This is Animal");
	}

	public void parentMethod() {
		System.out.println("This is method in Animal class.");
	}
}

interface Running {
	public void run();
}

class Horse extends Animal implements Running {

	@Override
	public void run() {
		System.out.println("Horse is running.");
	}

	@Override
	public void name() {
		System.out.println("This is Horse.");
	}
}

/*
 * In above code, Horse passes the IS-A test for Animal, Running, Object and
 * Horse. So it can be treated as polymorphic depending upon the reference type
 * declared, For Horse class, following declarations are valid. 
 * Horse horse = new Horse(); 	// since it is Horse itself. 
 * Animal animal = horse; 		// since Horse extends Animal. 
 * Running running = horse; 	// since Horse implements Running. 
 * Object obj = horse; 			// All java class is subclass of Object.
 */

/*
 * Now about method invocation, since java compiler invokes method depending
 * upon the reference type of declared object. name() method can be invoked by
 * horse and animal reference, since it is declared in Amimal class and
 * Overridden in Horse class. same for run() method, that is implemented in
 * Horse class and declared in Running interface.
 * 
 * If you will try to invoke run() method from animal reference, compiler show
 * you an ugly face saying that
 * "The method run() is undefined for type Animal..." since run() method is
 * unknown for Animal.
 */

class TestInvocation {
	public void invoke() {
		Horse horse = new Horse(); 		// since it is Horse itself.
		Animal animal = new Horse(); 	// since Horse extends Animal.
		Running running = new Horse(); 	// since Horse implements Running.
		Object obj = new Horse(); 		// All java class is subclass of Object.

		// Invoking name() method.
		horse.name();
		animal.name();

		// Invoking run() method.
		horse.run();
		running.run();

		// Invoking parentMethod()
		horse.parentMethod();
		animal.parentMethod();
	}

}

/*
 * 
 * All above discussion was about compiler, what about runtime behavior of
 * polymorphic instance. When we invoke name() method Animal reference, JVM
 * finds the actual object type at runtime. Since name() method is overridden in
 * Horse class, the JVM will invoke name() method of Horse class. So, method
 * invocation is resolved at runtime. Note that this polymorphic method
 * invocation is applicable only for instance methods. NOT static methods, NOT
 * variables.
 * 
 * One thing to keep in mind...
 * 
 * Polymorphic method invocations apply only to instance methods. You can always
 * refer to an object with a more general reference variable type (a superclass
 * or interface), but at runtime, the ONLY things that are dynamically selected
 * based on the actual object (rather than the reference type) are instance
 * methods. Not static methods. Not variables. Only overridden instance methods
 * are dynamically invoked based on the real object's type.
 * 
 * This can be referred as Runtime and Compile time Polymorphism.
 * 
 * The example above we have seen is Runtime Polymorphism as the method
 * invocation resolved at Runtime depending upon type of Object stored in Heap.
 * 
 * Runtime Polymorphism :
 * 
 * JVM will resolve that which method() to invoke by type of object stored in
 * heap at runtime. Invoking Onverridden method is example of Runtime
 * polymorphism.
 * 
 */

class Parent {
	public void method() {
		System.out.println("This is parent class method.");
	}
}

class Child extends Parent {
	@Override
	public void method() {
		System.out.println("This is chile class method.");
	}
}

class Test {
	public void invoke() {
		// Object of Parent class with Parent reference type.
		Parent parent1 = new Parent();
		// Object of Child class with Parent referece type.
		Parent parent2 = new Child();

		// This will invoke method() of Parent class.
		parent1.method();
		// This will invoke method() of Child class.
		parent2.method();
	}
}

/*
 * Compiletime Polymorphism :
 * 
 * Invocation of Overloaded method is example of Compiletime polymorphism. Flow
 * of execution will be decided at compilation of java program.
 */

class CompiletimeDemo {
	public void method() {
		System.out.println("Method with no parameter.");
	}

	public void method(String name) {
		System.out.println("Method with single parameter.");
	}

	public void method(String... name) {
		System.out.println("Method with dynamic parameter");
	}

	public void invoke() {
		CompiletimeDemo compile = new CompiletimeDemo();
		compile.method();
		compile.method("First Name");
		compile.method("First name","Last name");
	}
}

/*
 * In above example, Invocation of method() will be decided at compile time.
 * 
 */

public class TestPolymorphism {
	public static void main(String[] args) {
		System.out.println("");
		new TestInvocation().invoke();
		System.out.println("");
		new Test().invoke();
		System.out.println("");
		new CompiletimeDemo().invoke();
	}
}

/*
 * More on method overriding and method overloading will be described in next article.
 * Stay updated with Java by Examples.
 * 
 */