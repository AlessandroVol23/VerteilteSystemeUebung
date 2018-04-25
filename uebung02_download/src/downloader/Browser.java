package downloader;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Browser extends JFrame implements ActionListener {

	private int downloads;
	private JProgressBar[] balken;
	private JButton startButton;

	// Deklaration Ihrer Synchronisations-Hilfsklassen hier:

	private Lock lock = new ReentrantLock();
	private Condition waitCond = lock.newCondition();
	private ExecutorService es;
	private CountDownLatch latch;

	public Browser(int downloads) {
		super("Mein Download-Browser");
		this.downloads = downloads;

		// Initialisierung Ihrer Synchronisations-Hilfsklassen hier:
		this.es = Executors.newFixedThreadPool(this.downloads);
		this.latch = new CountDownLatch(this.downloads);

		// Aufbau der GUI-Elemente:
		balken = new JProgressBar[downloads];
		JPanel zeilen = new JPanel(new GridLayout(downloads, 1));

		for (int i = 0; i < downloads; i++) {
			JPanel reihe = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 10));
			balken[i] = new JProgressBar(0, 100);
			balken[i].setPreferredSize(new Dimension(500, 20));
			reihe.add(balken[i]);
			zeilen.add(reihe);

			// neue Download-Threads erzeugen und starten
			// ggf. m�ssen Synchronisations-Objekte im Konstruktor ueergeben
			// werden!!
			// balken ist ebenfalls zu uebergeben!
			// new Thread(new Download(balken[i], lock, waitCond)).start();
			es.execute(new Thread(new Download(balken[i], lock, waitCond, latch)));

		}

		startButton = new JButton("Downloads starten");
		startButton.addActionListener(this);

		this.add(zeilen, BorderLayout.CENTER);
		this.add(startButton, BorderLayout.SOUTH);

		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws InterruptedException {
		new Browser(5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Blockierte Threads jetzt laufen lassen:
		System.out.println("Klick on download starten");
		lock.lock();
		this.waitCond.signalAll();
		lock.unlock();

		startButton.setEnabled(false);
		startButton.setSelected(false);
		startButton.setText("Downloads laufen...");

		// Auf Ende aller Download-Threads warten ... erst dann die Beschriftung
		// aendern
		// Achtung, damit die Oberflaeche "reaktiv" bleibt dies in einem eigenen
		// Runnable ausfuehren!
		es.shutdown();
		try {
			while(!es.awaitTermination(60, TimeUnit.MINUTES)) {
				System.out.println("VORBEI");
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}

	public void end() {

		/*
		 * latch.await(); System.out.println("Vorbei");
		 */

		/*
		 * es.shutdown(); try { es.awaitTermination(Long.MAX_VALUE,
		 * TimeUnit.NANOSECONDS); System.out.println("VORBEI");
		 * 
		 * } catch (InterruptedException e) { }
		 */
		/*
		 * 
		 * if (es.isTerminated()) { System.out.println("VORBEI");
		 * 
		 * }
		 * 
		 */
		/*
		 * if (es.awaitTermination(60000, TimeUnit.SECONDS)) {
		 * 
		 * System.out.println("VORBEI"); }
		 */

	}

}
