package uebung03_02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Server {

	private static final int THREAD_POOLS_SIZE = 10;
	public static final ScheduledExecutorService RESPONDER_POOL = Executors.newScheduledThreadPool(THREAD_POOLS_SIZE);

	public static void main(String[] args) {

		try (ServerSocket server = new ServerSocket(81);) {
			System.out.println("Server an port 80 gestartet");
			System.out.println("Warte auf Verbindungen...");

			while (true) {

				// Warte auf neue Verbindung
				Socket clientConnection = server.accept();
				System.out.println("Neue Verbindung von " + clientConnection.getRemoteSocketAddress().toString());

				// Erstelle neue Verbindung und schick sie in Thread Pool
				Sockets newClient = new Sockets(clientConnection);
				RESPONDER_POOL.execute(newClient);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
