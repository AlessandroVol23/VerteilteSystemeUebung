package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import client.CallbackReferenceIF;
import server.entity.Bericht;
import server.entity.Roentgenbild;

public class FrueherkennungsServer implements FrueherkennungsIF {

	@Override
	public Bericht analysieren(Roentgenbild bild, CallbackReferenceIF ref) throws RemoteException {
		System.out.println("Bild erhalten");
		System.out.println("Beginne zu analysieren...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fertig analysiert, schicke Bestätigung!");
		ref.setBestaetigung(true);
		return null;
	}

	public static void main(String[] args) {

		try {
			// Server erstellen
			FrueherkennungsServer server = new FrueherkennungsServer();

			// Stub erstellen
			FrueherkennungsIF stub = (FrueherkennungsIF) UnicastRemoteObject.exportObject(server, 0);

			// Regisry locaten
			Registry reg = LocateRegistry.createRegistry(1099);
			
			// Stub in Registry binden
			reg.bind("LmuErkennungsService", stub);
			
			System.out.println("Server is up and ready!");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e1) {
			e1.printStackTrace();
		}

	}

}
