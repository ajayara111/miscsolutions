package my.experiment.code;

/*
 * What is Encapsulation.
 * 	Encapsulation is technique of binding all data members in single unit, and provide an public wrapped interface of those data members.
 * 	
 * 	What does it mean ?
 * 		Consider an example of car in which several parts (engine, wheels etc.) are binded altogether to create a public interface of car, public interface is what user can see.
 * 		Thats because, from user perspective, what user wants is to drive a car, not to run engine or just holding staring wheel. :p
 * 		And from developer perspective, if they want to modify working of engine, it will not effect public interface of car what user is interacting with.
 * 		What user is interacting with is public interface of car.
 * 
 * 	Note that Encapsulation is different from Information hiding.
 * 		Consider an example, To Encapsulate objects or thing is to wrap all those objects in a single room. you are not defining type of walls of that room it can be transparent or solid.
 * 		A good example of difference is an Class, by defining state (variables) and behavior (methods) you are encapsulating those, not restricting access.
 * 		You can achieve restriction by Hiding encapsulated information. i.e. declaring private or protected fields.
 */

class Difference {
	// Age is encapsulated but not hidden.
	public int age;
	public Difference ( int age ) {
		this.age = age ;
	}
}

/*
 * Encapsulation and Information hiding are different but highly related concepts.
 * Encapsulation is binding data members in such a way that one can clearly define what should be hidden and what should be not.
 * public interface of data members, accessor and mutator methods, are "API" by which external world is going to access private members.
 *  
 */

/*
 *	How to Implement :
 *		For example, consider a code
 */
	
class UserData {
	public int age;
}

class BadCode {
	public static void main(String args[]){
		UserData userData = new UserData();
		userData.age = -5; // Legal but not acceptable
	}
}

/*
 * In above code, assigning age = -5 is legal here but age can never be negative.
 * so, to prevent this you need to change definition of age variable in UserData class, but changing directly may effect some other part of your application.
 * Solution for this is to make age private and define mutator(setter) method, which is Information hiding indeed. i.e. making solid walls of your room in which you put age.
 * And to access it, use accessors(getter) method. 
 */

class HiddenUserData {
	// private encapsulated member.
	private int age;

	// public interface of age to get value.
	public int getAge() {
		return age;
	}

	// public interface of age to set value.
	public void setAge(int age) {
		assert age > 0 : "Invalid age";
			this.age = age;
	}	
}

class GoodCode {
	public static void main(String args[]){
		HiddenUserData userData = new HiddenUserData();
		userData.setAge(-5); // now age is invalid here.
	}
}

/*
 *  In this class, age and gender are encapsulated in EncapsulationDemo class.
 *  and hidden because those are private fields.
*/
public class EncapsulationDemo {
	
	// Here, age and gender are private member of EncapsulationDemo class 
	private int age;
	private String gender;
	
	// public interface of age to get value.
	public int getAge() {
		return age;
	}
	// public interface of age to set value.
	public void setAge(int age) {
		this.age = age;
	}
	// public interface of gender to get value.
	public String getGender() {
		return gender;
	}
	// public interface of gender to set value.
	public void setGender(String gender) {
		this.gender = gender;
	}
}

/*
 * Why we need encapsulation ?
 * 		It allows you to change some part of your code without affecting other modules. (Maintainability)
 * 		Restrict how the field access by public interface (getter method), or can make the fields read only (don't define public setter method).
 * 		Limit the value that a field can have (Ex. age more than 18).
 * 		Create immutable class.
 * 		Hiding complex implementation details and can switch to different field representation (Ex. format of date), to support Abstraction.
 * 
 */