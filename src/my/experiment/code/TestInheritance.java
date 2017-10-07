package my.experiment.code;

/*
 * Inheritance : It is a mechanism in which all the members of a class, called super class, will be derived in another class, referred as subclass.
 * Note that subclass will derive all members (methods, fields and nested classes) of super class. constructors are not members, it will not be inherited.
 * 
 * A class can not inherit more than one class, and all class will inherit members of Object class by default.
 * Object class in java.lang package will be inherited by all other class in java, or in other words Object class is super most class in inheritance hierarchy of any class.
 * 
 * Syntax :
 * 
 */

class Parent {
	// Parent class properties, i.e. methods, fields and nested classes
}

class Child extends Parent {
	// Properties of Child class.
	// Parent class' non-private properties also available in this class.
}

/*
 * Inheritance represents the "IS-A" relationship between two class.
 * In above example, Child IS-A Parent.
 * 
 * Reason to use Inheritance.
 * 
 * 1. For code Reusability
 * */

class Vehicle {
	// This is a generalized parent class.
	public void runEngine() {
		System.out.println("All vehicles has a engine.");
	}
}

class Bike extends Vehicle {
	// This is more specialized class Bike which will inherit generalized properties of Vehicle class.
	public int wheels = 2 ;
	public void runBike() {
		System.out.println("Bike is running.");
	}
}

class Car extends Vehicle {
	// This is more specialized class Car which will inherit generalized properties of Vehicle class.
	public int wheels = 4 ;
	public void runCar() {
		System.out.println("Car is running.");
	}
}

/* In above example, all generalized properties of Parent class Vehicle will be reused by their child class like Bike and Car.
 * Child class also define their more specialized properties.
 * 
 * 2. For Runtime Polymorphism.
 * 
 * Now consider a scenario where you want to loop through all subclass of Vehicle class.
 * You don't know all child class details of Vehicle class and you want to invoke a method which is inherited by all child class.
 * This can be done by Polymorphism. By this you can treat any child class of Vehicle as a Vehicle class.
 * 
 * Example :
 * 
 */


public class TestInheritance {

	public static void testPolymorphism(Vehicle vehicle) {
		vehicle.runEngine();
	}
	
	public static void main(String[] args) {
		Car car = new Car();
		Bike bike = new Bike();
		System.out.println("Invoking parent class method by runtime polymorphism.");
		testPolymorphism(car);
		testPolymorphism(bike);
		
		System.out.println("Invoking child class method.");
		car.runCar();
		bike.runBike();
	}
}

/*
 * Output : 
 * Invoking parent class method by runtime polymorphism.
 * All vehicles has a engine.
 * All vehicles has a engine.
 * Invoking child class method.
 * Car is running.
 * Bike is running.
 */

/* What you can do in child class?
 * From the JavaDoc
 * 
 * A subclass inherits all of the public and protected members of its parent, no matter what package the subclass is in. If the subclass is in the same package as its parent, it also inherits the package-private members of the parent. You can use the inherited members as is, replace them, hide them, or supplement them with new members:

 * The inherited fields can be used directly, just like any other fields.
 * You can declare a field in the subclass with the same name as the one in the superclass, thus hiding it (not recommended).
 * You can declare new fields in the subclass that are not in the superclass.
 * The inherited methods can be used directly as they are.
 * You can write a new instance method in the subclass that has the same signature as the one in the superclass, thus overriding it.
 * You can write a new static method in the subclass that has the same signature as the one in the superclass, thus hiding it.
 * You can declare new methods in the subclass that are not in the superclass.
 * You can write a subclass constructor that invokes the constructor of the superclass, either implicitly or by using the keyword super.
 * 
 * */