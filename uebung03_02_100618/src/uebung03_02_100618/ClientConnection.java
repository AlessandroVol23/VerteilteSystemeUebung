package uebung03_02_100618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

public class ClientConnection implements Runnable {

	private Socket socket;
	private OutputStream out;
	private InputStream in;
	private BufferedReader reader;
	private PrintWriter writer;
	private String pathWebFiles = "src/uebung03_02_100618/";

	public ClientConnection(Socket s) throws IOException {
		this.socket = s;
		this.out = this.socket.getOutputStream();
		this.in = this.socket.getInputStream();
		this.reader = new BufferedReader(new InputStreamReader(in));
		this.writer = new PrintWriter(out);
	}

	@Override
	public void run() {

		System.out.println("Client is starting....");

		try {
			// Client asks for: GET /bla HTTP/1.1
			String request = this.reader.readLine();

			System.out.println("Client asks for: " + request);
			String fileName = this.getFileName(request);
			
			String sendFile = "";
			
			List<String> indexFile = null;

			try {
				indexFile = Files.readAllLines(Paths.get(this.pathWebFiles + fileName));

			} catch (NoSuchFileException e) {

				System.out.println("File doesn't exist!");
				System.out.println("Show 404 page");
				indexFile = Files.readAllLines(Paths.get(this.pathWebFiles + "404.html"));
				
			}
			
			for (String s : indexFile) {
				// System.out.println(s);
				sendFile += s + "\n";
			}

			String header = this.buildHeader();

			String message = header + sendFile;

			// System.out.println("Answer is: \n" + message);

			writer.println(message);
			writer.println();
			writer.flush();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public String buildHeader() {

		String protocol = "HTTP/1.1 200 OK\r\n";
		String contentType = "Content-Type: text/html\r\n";
		String contentLength = "Content-Length: 944\r\n";
		String endOfHeader = "\r\n";

		String header = protocol + contentType + contentLength + endOfHeader;

		return header;
	}

	public String getFileName(String request) {

		// Client asks for: GET /bla HTTP/1.1
		String fileName = request.substring(request.indexOf('/') + 1, request.indexOf(" HTTP", (request.indexOf('/'))));
		System.out.println("Filename is: " + fileName);

		return fileName;
	}

}
