package test.designPattern;

public class BuilderPattern {

	public static void main(String[] args) {
		
		//creating two users with optional attributes
		System.out.println("First User:");
		User user1 = new User.UserBuilder("Alvin", "Lo").build();
		user1.displayUser();

		System.out.println("\nSecond User:");
		User user2 = new User.UserBuilder("bar", "foo").age(10).build();
		user2.displayUser();
		
		System.out.println("\nThird User:");
		User user3 = new User.UserBuilder("bar", "foo").age(10).phone("123").build();
		user3.displayUser();
	}
}

class User {
	private final String firstName; // required
	private final String lastName; // required
	private final int age; // optional
	private final String phone; // optional

	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
	}

	public void displayUser() {
		System.out.println("firstName: " + firstName);
		System.out.println("lastName: " + lastName);
		System.out.println("age: " + age);
		System.out.println("phone: " + phone);
	}

	// static builder reference
	public static class UserBuilder {
		private final String firstName;
		private final String lastName;
		private int age;
		private String phone;

		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}

		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}

		// calling the private construct
		public User build() {
			return new User(this);
		}
	}
}
