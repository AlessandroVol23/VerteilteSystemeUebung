import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Server {
	
	private static final int THREAD_POOLS_SIZE = 10;
	public static final ScheduledExecutorService RESPONDER_POOL = Executors.newScheduledThreadPool(THREAD_POOLS_SIZE);

	public static void main(String[] args) {

		int port = 1234;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		}
		try (ServerSocket server = new ServerSocket(port);) {
			System.out.println("Server an port " + port + " gestartet");
			System.out.println("Warte auf Verbindungen...");

			while (true) {

				// Warte auf neue Verbindung
				Socket clientConnection = server.accept();
				System.out.println("Neue Verbindung von " + clientConnection.getRemoteSocketAddress().toString());

				// Erstelle neue Verbindung und schick sie in Thread Pool
				Responder newClient = new Responder(clientConnection);
				RESPONDER_POOL.execute(newClient);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}