package uebung03_100618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Responder implements Runnable {

	private Socket socket;

	public Responder(Socket s) {
		this.socket = s;
	}

	@Override
	public void run() {

		System.out.println("Client connection started");

		while (true) {

			try {

				InputStream in = socket.getInputStream();
				OutputStream out = socket.getOutputStream();

				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				PrintWriter writer = new PrintWriter(out);

				String answer = reader.readLine();

				System.out.println("Antwort der Gegenseite " + answer);

				writer.println("Antwort von Server" + answer + "***");
				writer.flush();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
