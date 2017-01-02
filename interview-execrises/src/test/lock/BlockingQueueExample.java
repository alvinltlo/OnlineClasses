package test.lock;

/**
 * Using a blocking queue to implement producer and consumer problem
 */
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {
	static final LinkedBlockingQueue queue = new LinkedBlockingQueue(10);

	static class Consumer extends Thread {
		String name;

		public Consumer(String name) {
			this.name = name;
		}

		public void run() {
			try {

				while (true) {
					System.out.println("Consumer \"" + name + "\" read: "
							+ queue.take());
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
					queue.put(++N);
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
