package de.othr.vs;

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
		ServerSocket server = null;

		try {
			server = new ServerSocket(8080);

			while (true) {
				Socket client = server.accept();
				Runnable anfrage = new Client(client);
				new Thread(anfrage).start();
				System.out.println("Thread f�r Request gestartet!");

				InputStream in = in = client.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				OutputStream out = client.getOutputStream();
				PrintWriter writer = new PrintWriter(out);
				
				writer.println("Hallo");
				writer.flush();
				
				String antwort = reader.readLine();
				System.out.println("Antwort der Gegenseite: " + antwort);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
