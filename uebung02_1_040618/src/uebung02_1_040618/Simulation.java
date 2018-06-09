package uebung02_1_040618;

public class Simulation {

	public static void main(String[] args) {
		
		KitchenCounter counter = new KitchenCounter(4);
		Thread w1 = 	new Thread(new Waiter(counter, "Horst") );
		Thread w2 = new Thread(new Waiter(counter, "Berta") );
		
		w1.setDaemon(true);
		w2.setDaemon(true);
		
		w1.start();
		w2.start();
		
		
		
		for(int i=1;i<=8;i++) {
			Thread s = new Thread(new Student(counter, "Student+" + i));
			s.setDaemon(true);
			s.start();
		}
		
		try{
			Thread.sleep(30000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("ENDE");

	}

}
