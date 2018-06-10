package uebung03_02_100618;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	
	private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		
		
		int port = 8081;
		
		try {
			
			ServerSocket serverSocket = new ServerSocket(port);	
			System.out.println("Server is starting...");
			
			while(true) {
				
				try{
					System.out.println("Waiting for connections...");
					Socket clientConSocket = serverSocket.accept();
					
					System.out.println("Client with IP " + clientConSocket.getInetAddress().getHostAddress() + " is connected");
					ClientConnection clientCon = new ClientConnection(clientConSocket);
					threadPool.execute(clientCon);
					
					
					
					
				} catch(IOException e) {
					e.printStackTrace();
				}
				
				
			}
			
		} catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
		

	}

}
