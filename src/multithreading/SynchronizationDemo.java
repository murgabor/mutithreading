package multithreading;

public class SynchronizationDemo {

	private int count;

	public static void main(String[] args) throws InterruptedException {
		SynchronizationDemo sD = new SynchronizationDemo();
		sD.threadWork();

	}

	public synchronized void addCount() {
		count++;
	}

	private void threadWork() throws InterruptedException {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 12000; i++) {
					// count++;
					addCount();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 12000; i++) {
					// count++;
					addCount();
				}

			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Count:" + count);

	}

}
