package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import server.AufnahmeWunschIF;
import server.TvControllerIF;
import server.entity.Aufnahmewunsch;
import server.entity.Sendung;

public class SmartphoneApp {

	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			TvControllerIF stub = (TvControllerIF) reg.lookup("TvController");
			
			Sendung sendung = stub.getAktuelleSendung();
			System.out.println(sendung);
			
			stub.wechsleKanal(2);
			
			// Erstelle Wunsch
			Aufnahmewunsch wunsch = new Aufnahmewunsch();
			// Erstelle wunschStub und packe wunsch in den Stub
			AufnahmeWunschIF wunschStub = (AufnahmeWunschIF) UnicastRemoteObject.exportObject(wunsch,0);
			// Gebe den wunschstub weiter
			stub.registriereAufnahmewunsch(wunschStub);

			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
