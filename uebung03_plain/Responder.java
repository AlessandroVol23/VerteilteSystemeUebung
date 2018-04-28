import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Responder implements Runnable {

	private Socket clientConnection;

	public Responder(Socket clientConnection) {
		this.clientConnection = clientConnection;

	}

	@Override
	public void run() {

		System.out.println("Thread gestartet");
		while (true) {

			try {

				InputStream in = clientConnection.getInputStream();
				OutputStream out = clientConnection.getOutputStream();

				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				PrintWriter writer = new PrintWriter(out);

				String eingang = reader.readLine();

				System.out.println("Eingang von Client: *" + eingang + "*");

				writer.println("Antwort von Server: " + "*" + eingang + "*");
				writer.flush();

				if (eingang == "EXIT") {
					clientConnection.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}