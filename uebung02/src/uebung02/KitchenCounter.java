package uebung02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KitchenCounter {

	private int capacity;
	private int currentCapacity;
	private Lock lock = new ReentrantLock();
	private Condition full = lock.newCondition();
	private Condition empty = lock.newCondition();

	public KitchenCounter(int cap) {
		this.capacity = cap;
		this.currentCapacity = 0;

	}

	public void put() throws InterruptedException {

		lock.lock();

		while (this.currentCapacity >= this.capacity) {
			System.out.println("Kein Platz mehr fuer Leberkasssemmeln.\t Vorhanden: " + this.currentCapacity);
			System.out.println("==============================================================================");
			full.await();
		}

		this.currentCapacity++;
		System.out.println("Leberkasssemmel erstellt.\t Vorhanden: " + this.currentCapacity);
		System.out.println("==============================================================================");

		empty.signalAll();
		lock.unlock();

	}

	public void take() throws InterruptedException {

		lock.lock();

		while (this.currentCapacity <= 0) {
			System.out.println("Student muss warten.... \t Vorhanden: " + this.currentCapacity);
			System.out.println("==============================================================================");

			empty.await();
		}

		this.currentCapacity--;
		System.out.println("Leberkasssemmel gegessen.\t Vorhanden: " + this.currentCapacity);
		System.out.println("==============================================================================");

		full.signalAll();

		lock.unlock();

	}

}
