package test.lock;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * Using semaphore to solve producer and multiple consumer problems
 *
 */

public class SemaphoresExample {

	static LinkedList list = new LinkedList();

	/**
	 * Semaphore is a signaling mechanism. 0 is the inital permit value. It
	 * means that the Producer have to put a value into the list and then call
	 * mutex.release before Consumers can start reading from the list.
	 * 
	 */
	static Semaphore sem = new Semaphore(0);

	// mutex provides locking mechanism used to synchronize access to a resource
	static Semaphore mutex = new Semaphore(1);

	static class Consumer extends Thread {
		String name;

		public Consumer(String name) {
			this.name = name;
		}

		public void run() {
			try {
				while (true) {
					sem.acquire(1);
					mutex.acquire();
					System.out.println("Consumer \"" + name + "\" read: "
							+ list.removeFirst());
					mutex.release();
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
					mutex.acquire();
					list.add(new Integer(++N));
					mutex.release();
					sem.release(1);
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