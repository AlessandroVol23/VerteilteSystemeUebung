package uebung05_130618;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class FrueherkennungsServer implements FrueherkennungsIF {

	@Override
	public Bericht analysieren(Roentgenbild roentgenBild) throws RemoteException {
		System.out.println("Analysiere Bericht...");
		Bericht bericht = new Bericht(new Date(), "Alles gut", "Komm in 3 Jahren wieder");
		System.out.println("Analyse fertig! Schicke Bericht zurück...");
		return bericht;
	}
	
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		// Registry erstellen
		Registry reg = LocateRegistry.createRegistry(1099);
		System.out.println("Registry erstellt.");
		
		// Stub generieren
		FrueherkennungsIF frueherkennungsServer = new FrueherkennungsServer();
		FrueherkennungsIF stub = (FrueherkennungsIF) UnicastRemoteObject.exportObject(frueherkennungsServer, 0);
		
		// Stub an Registry binden
		reg.bind("FrueherkennungsService", frueherkennungsServer);
		System.out.println("Object an Registry gebunden.");
	}

}
