package uebung04_130618;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
	
	private static ExecutorService es = Executors.newFixedThreadPool(10);
	
	public static void main(String[] args) throws IOException {
			
		int port = 8081;
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Server is running on port " + port);
		
		while(true) {
			System.out.println("Waiting for Client connections...");
			Socket clientSocket = serverSocket.accept();
			
			ClientConnections clientConnection = new ClientConnections(clientSocket);
			
			es.execute(clientConnection);
			
			
			
			
		}
		
	}

}
