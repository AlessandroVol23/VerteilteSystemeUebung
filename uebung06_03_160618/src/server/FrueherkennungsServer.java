package server;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import entity.Bericht;
import entity.BerichtIF;
import entity.Roentgenbild;

public class FrueherkennungsServer implements FrueherkennungsInterface {

	public static void main(String[] args) throws IOException, AlreadyBoundException {

		// Registry erstellen
		Registry reg = LocateRegistry.createRegistry(1099);

		// Stub erstellen
		FrueherkennungsInterface server = new FrueherkennungsServer();
		FrueherkennungsInterface stub = (FrueherkennungsInterface) UnicastRemoteObject.exportObject(server, 0);

		// Stub an Server binden
		reg.bind("ErkennungsService", stub);

	}

	@Override
	public BerichtIF analysieren(Roentgenbild bild) throws RemoteException {
		System.out.println("Analysiere bild " + bild.toString());
		
		// Bericht Stub erstellen
		BerichtIF bericht = new Bericht(new Date(), "Alles gut", "Komm in 3 Jahren wieder");
		BerichtIF berichtStub = (BerichtIF)UnicastRemoteObject.exportObject(bericht, 0);
		
		
		

		return berichtStub;
	}

}
