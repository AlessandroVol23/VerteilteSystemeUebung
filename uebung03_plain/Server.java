import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		int port = 1234;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		}
		try {
			ServerSocket server = new ServerSocket(port);
			System.out.println("Server an port " + port + " gestartet");
			System.out.println("Warte auf Verbindungen...");

			Socket s = server.accept();
			System.out
					.println("Neue Verbindung von " + server.getInetAddress().getHostName() + server.getInetAddress());
			System.out.println("Hallo Welt!");

			InputStream in = s.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			OutputStream out = s.getOutputStream();
			PrintWriter writer = new PrintWriter(out);

			String eingang = reader.readLine();
			System.out.println(eingang);
			
			writer.println("Antwort von Server: " + "*" + eingang + "*");
			writer.flush();

			server.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}