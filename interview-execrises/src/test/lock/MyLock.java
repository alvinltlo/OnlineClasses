package test.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This example shows that mylock is locked by the main thread. The testThread
 * doesn't own the lock, and it throw a IllegalMonitorStateException when you
 * try to unlock
 *
 */

public class MyLock {

	private Lock lock;

	public MyLock() {
		lock = new ReentrantLock();
		lock.lock();
	}

	public static void main(String[] args) throws InterruptedException {
		MyLock myLock = new MyLock();
		TestThread tt = new TestThread(myLock);
		tt.start();
	}

	public void first() {
		lock.unlock();
	}
}

class TestThread extends Thread {
	MyLock myLock;

	public TestThread(MyLock myLock) {
		this.myLock = myLock;
	}

	public void run() {
		myLock.first();
	}
}
