package uebung04_130618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientConnections implements Runnable {

	private Socket socket;
	private InputStream in;
	private OutputStream out;
	private BufferedReader reader;
	private PrintWriter writer;

	public ClientConnections(Socket clientSocket) throws IOException {
		this.socket = clientSocket;
		this.in = this.socket.getInputStream();
		this.out = this.socket.getOutputStream();
		this.reader = new BufferedReader(new InputStreamReader(in));
		this.writer = new PrintWriter(out);

	}

	@Override
	public void run() {

		System.out.println("Client is connected!");
		System.out.println("Client is: " + this.socket.getInetAddress().getHostAddress());

		// End of command #
		// New parameter in command |
		// Commands are: REG, MSG, CHK

		// Input is for example: #REG|Sandro#
		while (true) {

			try {
				// Read Input from client
				String input = this.reader.readLine();
				System.out.println("Input is: " + input);

				// Get Command from input
				String command = this.getCommand(input);

				ArrayList<String> params = this.checkParams(input, command);
				
				for(String s : params) {
					System.out.println("Params: " + s);
				}
				
				
				

				switch (command) {
				case "REG":
					System.out.println("New User wants to register");
					User user = new User(params.get(0));
					User.addUserToDb(user);
					break;
				case "MSG":
					System.out.println("User wants to send a message");
					
					break;
				case "CHK":
					System.out.println("User wants to check new messages");
					break;
				default:
					break;

				}

				// this.socket.close();
				// System.out.println("Socket closed!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private ArrayList<String> checkParams(String input, String command) {
		ArrayList<String> paramsList = new ArrayList<>();
		String parameter = input.substring(3, input.length());
		char parameterArray[] = parameter.toCharArray();
		int count = 0;
		ArrayList<Integer> occurences = new ArrayList<>();
		

		/*
		 * e.g.: REG|SANDRO# MSG|sandro|oscar|hi# CHK#
		 * 
		 */


		System.out.println("Substing parameter is: " + parameter);

		
		// Check how many parameters we have
		for (int i = 0; i < parameterArray.length; i++) {
			if (parameterArray[i] == '|') {
				count++;
				occurences.add(i);
			}
		}

		System.out.println("Count is: " + count);

		switch (command) {
		case "REG":
			if (count != 1) {
				System.out.println("To register a User just one parameter is allowed!");
				return null;
			} else {
				paramsList.add(parameter.substring(occurences.get(0) + 1, parameter.length()-1));
				return paramsList;
			}
		case "MSG":
			if (count != 3) {
				System.out.println("To send a message just 3 parameters are allowed!");
				return null;

			} else {
				paramsList.add(parameter.substring(occurences.get(0) + 1, occurences.get(1)));
				paramsList.add(parameter.substring(occurences.get(1) + 1, occurences.get(2)));
				paramsList.add(parameter.substring(occurences.get(2) + 1, parameter.length() - 1));
				return paramsList;
			}
		case "CHK":
			if (count != 0) {
				System.out.println("To check your messages 0 parameters are allowed!");
				return null;
			} else {
				return paramsList;
			}
		default:
			break;

		}

		return null;
	}

	private String getCommand(String input) {
		// Return the first three letters
		String command = input.substring(0, 3);
		System.out.println("Command is: " + command);
		return command;
	}

}
