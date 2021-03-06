package uebung04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Server {

	public static UserDB userDB = new UserDB();
	public static MessageDB msgDB = new MessageDB();
	private static final int THREAD_POOLS_SIZE = 10;
	public static final ScheduledExecutorService RESPONDER_POOL = Executors.newScheduledThreadPool(THREAD_POOLS_SIZE);

	public static void main(String[] args) {

		try (ServerSocket server = new ServerSocket(81);) {
			System.out.println("Server an port 81 gestartet");
			System.out.println("Warte auf Verbindungen...");

			while (true) {

				// Warte auf neue Verbindung
				Socket clientConnection = server.accept();
//				InputStream in = clientConnection.getInputStream();
//				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//				String nachricht = reader.readLine();
				
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
