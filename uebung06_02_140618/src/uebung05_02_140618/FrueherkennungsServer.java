package uebung05_02_140618;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class FrueherkennungsServer implements FrueherkennungsIF {
	
	public static void main(String[] args) throws RemoteException, AlreadyBoundException{
		
		// Registry erstellen
		Registry reg = LocateRegistry.createRegistry(1099);
		System.out.println("Erstelle Registry.");
		
		// Stub erstellen
		FrueherkennungsIF service = new FrueherkennungsServer();
		FrueherkennungsIF stub = (FrueherkennungsIF)UnicastRemoteObject.exportObject(service, 0);
		System.out.println("Erstelle Stub");
		
		// Stub an Registry binden
		reg.bind("ErkennungsService", stub);
		System.out.println("Binde Stub an Registry");

		
		
	}

	@Override
	public Bericht analysieren(RoentgenbildIF bild) throws RemoteException {
		System.out.println("Analysiere folgendes Bild: " + bild.toString());
		
		Bericht bericht = new Bericht(new Date(), "Alles gut", "Komm bald wieder");
		return bericht;
	}

}
