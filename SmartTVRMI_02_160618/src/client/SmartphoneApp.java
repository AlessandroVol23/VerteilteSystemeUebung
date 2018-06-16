package client;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import entity.Aufnahmewunsch;
import entity.Codec;
import entity.Sendung;
import entity.SendungIF;
import server.TvControllerIF;

public class SmartphoneApp {
	
	public static void main(String[] args) throws IOException, NotBoundException{
		
		// Registry holen
		Registry reg = LocateRegistry.getRegistry(1099);
		
		// Stub holen
		TvControllerIF smartTvStub = (TvControllerIF) reg.lookup("SmartTV");
		
		// Entity Stub holen
		SendungIF sendung = new Sendung("Alarm Cobra 11", "Polizisten auf der Autobahn");
		SendungIF sendungStub = (SendungIF) UnicastRemoteObject.exportObject(sendung, 0);
		
		// BL ausführen
//		smartTvStub.wechsleKanal(5);
		
//		smartTvStub.registriereAufnahmewunsch(new Aufnahmewunsch(Codec.DIVX));
		
		smartTvStub.setAktuelleSendung(sendungStub);
		
//		System.out.println(smartTvStub.getAktuelleSendung());
	}

}
