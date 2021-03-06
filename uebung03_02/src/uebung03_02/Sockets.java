package uebung03_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sockets implements Runnable {

	private Socket clientConnection;
	private List<String> lines;
	private String pathWebFiles = "src/uebung03_02";
	private final Pattern _pathPattern = Pattern.compile("\\/.*.html");
	private ArrayList<String> header = new ArrayList<String>();

	public Sockets(Socket clientConnection) {
		this.clientConnection = clientConnection;
	}

	@Override
	public void run() {
		System.out.println("Thread gestartet!");

		try {

			InputStream in = clientConnection.getInputStream();
			OutputStream out = clientConnection.getOutputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			PrintWriter writer = new PrintWriter(out);

			String request = reader.readLine();
			System.out.println(request);

			this.createPackage(request);
			for (String s : this.header) {
				writer.println(s);
			}

			// writer.println("HTTP/1.1 200 ok");
			// writer.println("Content-Type: text\\html");
			// writer.println("Content-Length: 200");
			// writer.println();
			// for (String line : lines) {
			// // System.out.println(line);
			// writer.println(line);
			// }
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void createPackage(String request) {

		Matcher matcher = _pathPattern.matcher(request);
		if (matcher.find()) {
			String uri = matcher.group(0).toString();
			// System.out.println(uri);

			try {
				lines = Files.readAllLines(Paths.get(this.pathWebFiles + uri));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			this.header.add("HTTP/1.1 200 ok");
			this.header.add("Content-Type: text\\html");
			this.header.add("Content-Length: 200");
			this.header.add("\n");
			for (String line : lines) {
				// System.out.println(line);
				this.header.add(line);
			}
		}

	}

}
