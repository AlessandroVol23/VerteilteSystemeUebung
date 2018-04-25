
public class mainTest {

	public static void main(String[] args) {
		QueueTest qt = new QueueTest();
		Auto a1 = new Auto("1");
		Auto a2 = new Auto("2");
		qt.ad.addLast(a1);
		qt.ad.addLast(a2);
		System.out.println(qt.ad.poll().name);
	}
}
