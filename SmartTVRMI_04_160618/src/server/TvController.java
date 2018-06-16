package server;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import client.CallbackIF;
import entity.Aufnahmewunsch;
import entity.Sendung;

public class TvController implements TvControllerIF {

	private int aktuellerKanal;
	private ArrayList<Aufnahmewunsch> wunschListe = new ArrayList<>();
	private Sendung aktuelleSendung;
	
	public TvController() {
		this.aktuelleSendung = new Sendung("BLA", "BLABLA");
	}

	public static void main(String[] args) throws IOException, AlreadyBoundException {

		// Registry erstellen
		Registry reg = LocateRegistry.createRegistry(1099);

		// Server Stub erstellen
		TvControllerIF server = new TvController();
		TvControllerIF stub = (TvControllerIF) UnicastRemoteObject.exportObject(server, 0);

		// Stub an Reg binden
		reg.bind("SmartTV", stub);

		System.out.println("Server Ready. Waiting for connections....");
	}

	@Override
	public Sendung getAktuelleSendung() throws RemoteException {
		System.out.println("Sende aktuelle Sendung zu Client...");
		return this.aktuelleSendung;

	}

	@Override
	public void registriereAufnahmewunsch(Aufnahmewunsch wunsch) throws RemoteException {
		this.wunschListe.add(wunsch);
		System.out.println("Added Wunsch: " + wunsch + " to wunschliste");

	}

	@Override
	public void wechsleKanal(int neuerKanal) throws RemoteException {
		this.aktuellerKanal = neuerKanal;
		System.out.println("Wechsle Kanal zu " + neuerKanal);

	}

	@Override
	public void setAktuelleSendung(Sendung _sendung) throws RemoteException {
		this.aktuelleSendung = _sendung;
		System.out.println("Changed Sendung to: " + this.aktuelleSendung);

	}

	@Override
	public void aufnehmen(CallbackIF callback) throws RemoteException {
		System.out.println("Starte Aufnahme bis zu Endzeitpunkt");
		
//		Date aktuelleZeit = new Date();

		while (this.aktuelleSendung.getEndzeitpunkt().after(new Date())) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Aufnahme fertig!");
		
		callback.aufnahmeFertig("PFAD");
		
		
	}

}
