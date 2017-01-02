package test.java;

import java.util.Date;

/**
 * template for creating immutable objects. Make all fields private Don't
 * provide mutators Ensure that methods can't be overridden by either making the
 * class final (Strong Immutability) or making your methods final (Weak
 * Immutability) If a field isn't primitive or immutable, make a deep clone on
 * the way in and the way out.
 */
public class DefensiveCopyExample {

	public static void main(String[] args) {

		DefensiveCopyExample dcd = new DefensiveCopyExample();
		Date birthDate = new Date();
		Student s1 = dcd.new Student(birthDate);
		System.out.println("default B-date: \t" + s1.getBirthDate());

		// unintentional changes to birthdate.
		// We are not changing it through the student object.
		birthDate.setYear(2019);
		System.out.println("bad change B-date: \t" + s1.getBirthDate());

		// better implementation
		birthDate = new Date();
		Student2 s2 = dcd.new Student2(birthDate);
		System.out.println("default B-date: \t" + s2.getBirthDate());
		birthDate.setYear(2019);
		System.out.println("better change B-date: \t" + s2.getBirthDate());

		// however, people can still do this
		s2.getBirthDate().setYear(2020);
		System.out.println("bad 2 change B-date: \t" + s2.getBirthDate());

		// fully immutable class
		birthDate = new Date();
		Student3 s3 = dcd.new Student3(birthDate);
		System.out.println("default B-date: \t" + s3.getBirthDate());
		birthDate.setYear(2019);
		s3.getBirthDate().setDate(2020);
		System.out.println("immutable B-date: \t" + s3.getBirthDate());
	}

	class Student {
		private Date birthDate;

		public Student(Date birthDate) {
			this.birthDate = birthDate;
		}

		public Date getBirthDate() {
			return birthDate;
		}
	}

	class Student2 {
		private Date birthDate;

		public Student2(Date birthDate) {
			this.birthDate = new Date(birthDate.getTime());
		}

		public Date getBirthDate() {
			return birthDate;
		}
	}

	class Student3 {
		private Date birthDate;

		public Student3(Date birthDate) {
			this.birthDate = new Date(birthDate.getTime());
		}

		public Date getBirthDate() {
			return new Date(this.birthDate.getTime());
		}
	}
}
