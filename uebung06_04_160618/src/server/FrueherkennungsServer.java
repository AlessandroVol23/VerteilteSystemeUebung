package server;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import client.CallbackIF;
import entity.Bericht;
import entity.Roentgendbild;

public class FrueherkennungsServer implements FrueherkennungsIF {
	
	public static void main(String[] args) throws IOException, AlreadyBoundException{
		// Registry erstellen
		Registry reg = LocateRegistry.createRegistry(1099);
		
		// Server Stub erstellen
		FrueherkennungsIF server = new FrueherkennungsServer();
		FrueherkennungsIF stub = (FrueherkennungsIF) UnicastRemoteObject.exportObject(server, 0);
		
		// Stub an Reg binden
		reg.bind("ErkennungsService", stub);
	}

	@Override
	public void analysieren(Roentgendbild bild, CallbackIF referenz) throws RemoteException {
		System.out.println("Analysiere bild " + bild.toString());
		
		Bericht bericht = new Bericht(new Date(), "Alles gut", "Komm in 3 Jahren wieder");
		
		System.out.println("Sende Callback");
		referenz.setBericht(bericht);
		
	}

}
