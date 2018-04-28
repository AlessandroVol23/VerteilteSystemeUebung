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

		int port = 81;
		String hostname = "localhost";
		if (args.length == 2) {
			port = Integer.parseInt(args[1]);
			hostname = args[0];
		}

		try {
			Socket s = new Socket(hostname, port);

			while (true) {
				InputStream in = s.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				OutputStream out = s.getOutputStream();
				PrintWriter writer = new PrintWriter(out);

//				String antwort = reader.readLine();

				Scanner scanner = new Scanner(System.in);
				String eingabe = scanner.nextLine();

				writer.println(eingabe);
				writer.flush();

				if (eingabe == "EXIT") {
					s.close();
					scanner.close();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}