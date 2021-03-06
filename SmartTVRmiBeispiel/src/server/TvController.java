package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import server.entity.Aufnahmewunsch;
import server.entity.Sendung;

public class TvController implements TvControllerIF {
	private int aktuellerKanal = 1;

	public static void main(String[] args) {
		
		
		try {
			System.out.println("Ersteller TV Controller und Stub.");
			TvControllerIF tvController = new TvController();
			TvControllerIF stub = (TvControllerIF) UnicastRemoteObject.exportObject(tvController, 0);
			
			System.out.println("Erstelle Registry.");
			
			// Registry liegt normalerweise irgendwo im Netzwerk 
			Registry reg = LocateRegistry.createRegistry(1099);
			
			// Stub in Registry (Key-Value) veröffentlichen
			reg.bind("TvController", stub);
			
			System.out.println("Server bereit...");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Sendung getAktuelleSendung() throws RemoteException {
		System.out.println("TvController: Sende aktuelle Sendung");
		return new Sendung("Tatort", "einer stirbt, zwei ermitteln");
	}

	@Override
	public void registriereAufnahmewunsch(AufnahmeWunschIF aufnahmewunsch) throws RemoteException {
		System.out.println("TvController: Aufnahme von " + aufnahmewunsch.ausgabe());
	}

	@Override
	public void wechsleKanal(int neuerKanal) throws RemoteException {
		System.out.println("Wechsle von Kanal " + aktuellerKanal + "auf Kanal " + neuerKanal);
		this.aktuellerKanal = neuerKanal;
	}

}
