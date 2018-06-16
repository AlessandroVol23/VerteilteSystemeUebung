package uebung05_01_140618;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class FrueherkennungsServer implements FrueherkennungsIF {

	public static void main(String[] args) throws IOException, AlreadyBoundException {

		// Registry erstellen
		Registry reg = LocateRegistry.createRegistry(1099);
		System.out.println("Registry erstellt.");

		// Stub erstellen
		FrueherkennungsIF frueherkennungsService = new FrueherkennungsServer();
		FrueherkennungsIF stub = (FrueherkennungsIF) UnicastRemoteObject.exportObject(frueherkennungsService, 0);
		System.out.println("Stub erstellt.");

		// Stub an Registry binden
		reg.bind("ErkennungsService", stub);
		System.out.println("Stub an Registry gebunden.");
	}

	@Override
	public Bericht analysiere(Roentgenbild bild) throws RemoteException {
		System.out.println("Analysiere Bild: " + bild.toString());
		
		Bericht bericht = new Bericht(new Date(), "Alles gut", "Komm in 3 Jahren wieder");
		
		return bericht;
	}

}
