package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import server.entity.Bericht;
import server.entity.BerichtIF;

public class UniklinikumRegensburg {

	public static void main(String[] args) {

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			
			Bericht bericht = new Bericht("Alles schlecht", "Komm morgen wieder");
			BerichtIF berichtStub = (BerichtIF) UnicastRemoteObject.exportObject(bericht, 0);
			System.out.println(berichtStub.ausgabe());
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

}
