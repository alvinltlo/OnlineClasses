package test.lock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	static Lock lock = new ReentrantLock();
	static Condition ready = lock.newCondition();
	static boolean valueReady = false;
	static LinkedList list = new LinkedList();

	static class Consumer extends Thread {
		String name;

		public Consumer(String name) {
			this.name = name;
		}

		public void run() {
			try {

				while (true) {
					lock.lock();
					while (!valueReady)
						ready.await();
					System.out.println("Consumer \"" + name + "\" read: "
							+ list.removeFirst());
					valueReady = false;
					ready.signalAll();
					lock.unlock();
					Thread.sleep(500);
				}
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
	}

	static class Producer extends Thread {
		public void run() {
			try {
				int N = 0;
				while (true) {
					lock.lock();
					while (valueReady)
						ready.await();
					System.out.println("Producer write: " + ++N);
					list.add(new Integer(N));
					valueReady = true;
					ready.signalAll();
					lock.unlock();
					Thread.sleep(500);
				}
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Producer().start();
		new Consumer("Alice").start();
		new Consumer("Bob").start();
	}
}