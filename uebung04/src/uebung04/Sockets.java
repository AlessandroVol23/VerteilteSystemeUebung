package uebung04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Sockets implements Runnable {

	private Socket clientConnection;
	private BufferedReader reader;
	private PrintWriter writer;
	private InputStream in;
	private OutputStream out;
	// private String nachricht;

	public Sockets(Socket _clientConnection) {
		this.clientConnection = _clientConnection;
	}

	public Sockets() {

	}

	@Override
	public void run() {

		System.out.println("Thread gestartet");
		this.empfangeNachricht();

		// Warte auf neue Verbindung

		// try {
		//
		// this.in = clientConnection.getInputStream();
		// this.out = clientConnection.getOutputStream();
		//
		// this.writer = new PrintWriter(out);
		//
		// this.reader = new BufferedReader(new InputStreamReader(in));
		// this.empfangeNachricht();
		// // writer.println("TEST");
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

	}

	public void empfangeNachricht() {

		while (true) {
			try {
				InputStream in = clientConnection.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				String nachricht = reader.readLine();

				// String nachricht = reader.readLine();
				System.out.println("Nachricht ist: " + nachricht);
				int index = nachricht.indexOf("#");
				String action = nachricht.substring(0, index);
				System.out.println("Action is: " + action);

				switch (action) {
				case "REG":
					System.out.println("In Case REG");
					this.reg(nachricht);
					break;

				case "SEND":
					this.send(nachricht.substring(index + 1));
					break;

				case "GET":

					this.get(nachricht.substring(index + 1, nachricht.length() - 1));
					break;
				default:
					System.out.println("Falsche ACTION");
					break;
				}

				// clientConnection.close();
				// System.out.println("Schliesse clientConnection...");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void reg(String nachricht) {
		// REG#SANDRO#
		// System.out.println("In Funktion REG");
		int indexFirst = nachricht.indexOf("#");
		// System.out.println("Index First is: " + indexFirst);
		int indexLast = nachricht.lastIndexOf("#");
		// System.out.println("indexLast is: " + indexLast);
		String userName = nachricht.substring(indexFirst + 1, indexLast);
		System.out.println("userName is: " + userName);
		User newUser = new User(userName);
		Server.userDB.addUser(newUser);
		System.out.println("Registration vorbei! ");

	}

	public void send(String nachrichtWithoutAction) {
		// SANDRO#OSCAR#hallo
		int indexFirst = nachrichtWithoutAction.indexOf("#");
		String usernameFrom = nachrichtWithoutAction.substring(0, indexFirst);
		System.out.println("Message is from: " + usernameFrom);

		String nachrichtAfterSender = nachrichtWithoutAction.substring(indexFirst + 1);
		System.out.println("Substring is: " + nachrichtAfterSender);
		// OSCAR#hallo
		int index = nachrichtAfterSender.indexOf("#");
		String empfaenger = nachrichtAfterSender.substring(0, index);
		System.out.println("Message goes to: " + empfaenger);

		String nachricht = nachrichtAfterSender.substring(index + 1, nachrichtAfterSender.length() - 1);
		System.out.println("Message is: " + nachricht);

		Message newMessage = new Message(Server.userDB.searchuser(usernameFrom), Server.userDB.searchuser(empfaenger),
				nachricht);

		Server.msgDB.addNewMessage(newMessage);

	}

	public void get(String nachricht) {
		// SANDRO#
		System.out.println("Rufe alle Nachrichten fuer " + nachricht + " ab...");
		int i = 1;
		for (Message m : Server.msgDB.getAllMessagesForUser(Server.userDB.searchuser(nachricht))) {
			System.out.println("Message " + i + ": " + m.getMessage());
			i++;
		}

	}

}
