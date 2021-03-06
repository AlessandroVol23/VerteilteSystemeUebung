package de.othr.vs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {

	private Socket socket;

	public Client(Socket client) {
		this.socket = client;
	}

	@Override
	public void run() {

		try {

			// Lesen und schreiben in aus dem Socket
			// Gets hier drinnen
			InputStream in = socket.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			OutputStream out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out);

			System.out.println(reader.readLine());
			System.out.println(reader.readLine());
			System.out.println(reader.readLine());
			System.out.println(socket.getInetAddress());

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
