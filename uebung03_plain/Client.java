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

		int port = 1234;
		String hostname = "localhost";
		if (args.length == 2) {
			port = Integer.parseInt(args[1]);
			hostname = args[0];
		}

		try {
			Socket s = new Socket(hostname, port);

			InputStream in = s.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			OutputStream out = s.getOutputStream();
			PrintWriter writer = new PrintWriter(out);

			Scanner scanner = new Scanner(System.in);
			String eingabe = scanner.nextLine();
			writer.println(eingabe);
			writer.flush();

			String antwort = reader.readLine();
			System.out.println(antwort);

			s.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}