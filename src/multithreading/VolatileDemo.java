package multithreading;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Tasker extends Thread {

	// a volatile meggátolja, hogy cash-elve legyen
	private volatile boolean runner = true;

	@Override
	public void run() {

		while (runner) {
			try {
				System.out.println("Futok");
				Thread.sleep(1000);
			} catch (Exception ex) {
				// TODO: handle exception
				Logger.getLogger(Tasker.class.getName()).log(Level.SEVERE, null, ex);
			}

		}

	}

	public void kill() {
		this.runner = false;
	}

}

public class VolatileDemo {
	public static void main(String[] args) {
		// Elindul a Main szál

		// Most elindítjuk a másik szálat
		Tasker t1 = new Tasker();
		t1.start();

		System.out.println("Nyomj enter-t a szüneteltetéshez!");

		// A Main szál itt megáll, amíg ENTER-t nem nyomunk
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		sc.nextLine();

		// Enter-t nyomtak, megyünk tovább
		t1.kill();

	}

}
