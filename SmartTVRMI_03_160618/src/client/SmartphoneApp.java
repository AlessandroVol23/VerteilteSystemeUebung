package client;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import entity.Aufnahmewunsch;
import entity.AufnahmewunschIF;
import entity.Codec;
import entity.Sendung;
import server.TvControllerIF;

public class SmartphoneApp {
	
	public static void main(String[] args) throws IOException, NotBoundException{
		
		// Registry holen
		Registry reg = LocateRegistry.getRegistry(1099);
		
		// Stub holen
		TvControllerIF smartTvStub = (TvControllerIF) reg.lookup("SmartTV");
		
		// Aufnahmewunsch Stub holen
		AufnahmewunschIF wunsch = new Aufnahmewunsch(Codec.DIVX);
		System.out.println("Wunsch erstellt mit Codec: " + wunsch.getCodec());
		AufnahmewunschIF wunschStub = (AufnahmewunschIF) UnicastRemoteObject.exportObject(wunsch, 0);
		
		
		// BL ausführen
//		smartTvStub.wechsleKanal(5);
		
		smartTvStub.registriereAufnahmewunsch(wunschStub);
		
//		smartTvStub.setAktuelleSendung(new Sendung("Rosarote Pilcher", "Gute Serie"));
		
//		System.out.println(smartTvStub.getAktuelleSendung());
	}

}
