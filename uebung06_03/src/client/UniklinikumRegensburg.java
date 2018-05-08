package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import server.FrueherkennungsIF;
import server.entity.Bericht;
import server.entity.BerichtIF;
import server.entity.Roentgenbild;

public class UniklinikumRegensburg {

	public static void main(String[] args) {

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
//			try {
//				FrueherkennungsIF server = (FrueherkennungsIF) reg.lookup("LmuFrueherkennungsService");
//			} catch (NotBoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			server.analysiere(bild);
			
			Bericht bericht = new Bericht("Alles schlecht", "Komm morgen wieder");
			BerichtIF berichtStub = (BerichtIF) UnicastRemoteObject.exportObject(bericht, 0);
			System.out.println(berichtStub.ausgabe());
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

}
