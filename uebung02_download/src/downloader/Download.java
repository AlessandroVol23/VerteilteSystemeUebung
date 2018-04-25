package downloader;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JProgressBar;

public class Download implements Runnable {

	JProgressBar balken;
	int count = 0;
	private Lock lock;
	private Condition waitCond;
	private CountDownLatch latch;

	public Download(JProgressBar balken, Lock lock, Condition waitCond, CountDownLatch latch) {
		this.balken = balken;
		this.lock = lock;
		this.waitCond = waitCond;
		this.latch = latch;
	}

	@Override
	public void run() {
		lock.lock();
		try {
			waitCond.await();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		latch.countDown();
		lock.unlock();

		for (int i = 0; i < 100; i++) {

			try {
				Thread.sleep(new Random().nextInt(50));
				this.balken.setValue(++count);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void wakeUp() {
		waitCond.signalAll();
	}

}
