package uebung03_100618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		String hostname = "localhost";
		int port = 8081;

		try {
			Socket socket = new Socket(hostname, port);
			System.out.println("Connect to " + hostname + ":" + port);
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			OutputStream out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out);

			System.out.println("Sending Message...");

			while (true) {

				Scanner scanner = new Scanner(System.in);
				String eingabe = scanner.nextLine();

				writer.println(eingabe);
				writer.flush();

				String answerFromServer = reader.readLine();
				System.out.println(answerFromServer);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
