package test.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		// Paramters
		Object[] params = new Object[] { "Alvin", "Lo" };

		// Get class
		Class personDef = Class.forName("test.java.Person");

		// Call constructor
		Class[] paramsClass = new Class[] { String.class, String.class };
		Constructor personConstructor = personDef.getConstructor(paramsClass);
		Person person = (Person) personConstructor.newInstance(params);
		
		//Call methods
		Method method = personDef.getDeclaredMethod("printName");
	    method.invoke(person);	
	}
}

class Person {
	String firstName, lastName;

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void printName() {
		System.out.println("My Name is " + firstName + " " + lastName);
	}
}