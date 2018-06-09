package downloader;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JProgressBar;

// aktive Klasse
public class Download implements Runnable {

	private final JProgressBar balken;
	private Lock waitTillStartLock;
	private Condition monitor;
	private CountDownLatch latch;
	// weitere Attribute zur Synchronisation hier definieren

	public Download(JProgressBar balken, Lock _waitTillStartLock, Condition _monitor, CountDownLatch _latch) {
		this.balken = balken;
		this.waitTillStartLock = _waitTillStartLock;
		this.monitor = _monitor;
		this.latch = _latch;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.waitTillStartLock.lock();
		
		try {
			monitor.await();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.waitTillStartLock.unlock();

		for (int i = 0; i < 100; i++) {

			int randomNumber = new Random().nextInt(200);
//			System.out.println("Random Number is: " + randomNumber);
//			System.out.println("Current Value of the balken is: " + this.balken.getValue());
			this.balken.setValue(this.balken.getValue() + 2);
//			System.out.println("New Value of the balken is: " + this.balken.getValue());

			try {
				TimeUnit.MILLISECONDS.sleep(randomNumber);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		this.latch.countDown();
		
		
	}

	/*
	 * hier die Methode definieren, die jeweils den Balken weiterschiebt Mit
	 * balken.getMaximum() bekommt man den Wert fuer 100 % gefuellt Mit
	 * balken.setValue(...) kann man den Balken einstellen (wieviel gefuellt)
	 * dargestellt wird Setzen Sie den value jeweils und legen Sie die Methode
	 * dann für eine zufaellige Zeit schlafen
	 */

}
