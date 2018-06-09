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
	private ExecutorService es;
	private Lock waitTillStartLock;
	private Condition monitor;
	private CountDownLatch latch;

	// Deklaration Ihrer Synchronisations-Hilfsklassen hier:

	public Browser(int downloads) throws InterruptedException {
		super("Mein Download-Browser");
		this.downloads = downloads;
		this.latch = new CountDownLatch(this.downloads);

		// Initialisierung Ihrer Synchronisations-Hilfsklassen hier:
		this.es = Executors.newFixedThreadPool(5);
		waitTillStartLock = new ReentrantLock();
		this.monitor = waitTillStartLock.newCondition();

		// Aufbau der GUI-Elemente:
		balken = new JProgressBar[downloads];
		JPanel zeilen = new JPanel(new GridLayout(downloads, 1));

		for (int i = 0; i < downloads; i++) {
			JPanel reihe = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 10));
			balken[i] = new JProgressBar(0, 100);
			balken[i].setPreferredSize(new Dimension(500, 20));
			reihe.add(balken[i]);
			zeilen.add(reihe);

			es.execute(new Download(balken[i], waitTillStartLock, monitor, latch));

			// neue Download-Threads erzeugen und starten
			// ggf. müssen Synchronisations-Objekte im Konstruktor übergeben
			// werden!!
			// balken ist ebenfalls zu übergeben!

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
		waitTillStartLock.lock();
		monitor.signalAll();
		waitTillStartLock.unlock();

		startButton.setEnabled(false);
		startButton.setSelected(false);
		startButton.setText("Downloads laufen...");

		
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					latch.await();
					startButton.setText("ENDE");
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		}).start();
	
	}

}
