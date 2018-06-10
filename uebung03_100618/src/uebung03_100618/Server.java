package uebung03_100618;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		
		int port = 8081;
		
		try(ServerSocket serverSocket = new ServerSocket(port)) {
			
			while(true) {
				
				System.out.println("Starting Server....");
				System.out.println("Waiting for Client...");
				
				try{
					
					Socket socket = serverSocket.accept();
					System.out.println("New connection from " + socket.getInetAddress().getHostName());
					Responder responder = new Responder(socket);
					new Thread(responder).start();		
					
					
				} catch(IOException e) {
					e.printStackTrace();
				}
				
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
