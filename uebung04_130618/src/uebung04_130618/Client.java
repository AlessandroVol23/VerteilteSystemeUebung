package uebung04_130618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	private InputStream in;
	private OutputStream out;
	private BufferedReader reader;
	private PrintWriter writer;
	
	
	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket("localhost", 8081);
		System.out.println("Connection to server established.");
		
		InputStream in;
		OutputStream out;
		BufferedReader reader;
		PrintWriter writer;
		
		in = socket.getInputStream();
		out = socket.getOutputStream();
		reader = new BufferedReader(new InputStreamReader(in));
		writer = new PrintWriter(out);
		
		while(true) {
			// Waiting for input from console
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			writer.println(input);
			writer.flush();
		}
		
		
	}

}
