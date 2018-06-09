package uebung02_1_040618;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KitchenCounter {

	private int capacity;
	private int currentLeberkassemmeln = 0;

	private Lock monitor = new ReentrantLock();
	private Condition takeLock = monitor.newCondition();
	private Condition putLock = monitor.newCondition();

	public KitchenCounter(int _capacity) {
		this.capacity = _capacity;
	}

	public void put() {
		// One Leberkassemmel more
		monitor.lock();

		while (this.currentLeberkassemmeln >= this.capacity) {
			try {
				System.out.println("KitchenCounter is full of Leberkasssemmeln. Please wait...");
				putLock.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		putLock.signal();

		this.currentLeberkassemmeln++;
		System.out.println("Leberkasssemmel abgelegt.");

		monitor.unlock();
		this.printCurrentLeberkasssemmel();

	}

	public void take() {
		// One Leberkasssemmel less

		monitor.lock();

		while (this.currentLeberkassemmeln <= 0) {
			try {
				System.out.println("No Leberkasssemmeln at the Counter! Please wait...");
				takeLock.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		takeLock.signal();

		this.currentLeberkassemmeln--;
		System.out.println("Take Leberkasssemmel...");

		monitor.unlock();
		this.printCurrentLeberkasssemmel();
	}

	public void printCurrentLeberkasssemmel() {
//		System.out.println("-----------------------------------------------------");
		System.out.println("Current Leberkasssemmeln: " + this.currentLeberkassemmeln);
		System.out.println("-----------------------------------------------------");
	}

}
