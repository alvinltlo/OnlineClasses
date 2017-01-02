package test.designPattern;

public class SingletonPattern {

	public static void main(String[] args) {
		// 4 different implementations
		SingletonImp1 s1 = SingletonImp1.getInstance();
		SingletonImp2 s2 = SingletonImp2.getInstance();
		SingletonImp3 s3 = SingletonImp3.INSTANCE;
		s3.doStuff();
		SingletonImp4 s4 = SingletonImp4.getInstnace();
	}

}

/**
 * Use synchronized method, will work but has performance issue
 */
class SingletonImp1 {
	private static SingletonImp1 INSTANCE;

	private SingletonImp1() {
	}

	public static synchronized SingletonImp1 getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SingletonImp1();
		return INSTANCE;
	}
}

/**
 * Based on initilalization-on-demand holder idiom LazyHolder class will not be
 * initialized until required
 */
class SingletonImp2 {
	private SingletonImp2() {
	};

	private static class LazyHolder {
		private static final SingletonImp2 INSTANCE = new SingletonImp2();
	}

	public static SingletonImp2 getInstance() {
		return LazyHolder.INSTANCE;
	}
}

/**
 * Java 1.5+, best way to implement singleton
 */
enum SingletonImp3 {
	INSTANCE;
	public void doStuff() {
		System.out.println("whatever you want to use your singleton for");
	}
}

/**
 * Using static factory method
 *
 */
class SingletonImp4 {
	private static final SingletonImp4 INSTANCE = new SingletonImp4();

	private SingletonImp4() {
	}

	public static SingletonImp4 getInstnace() {
		return INSTANCE;
	}
}