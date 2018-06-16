package client;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import entity.Aufnahmewunsch;
import entity.Codec;
import entity.Sendung;
import server.TvControllerIF;

public class SmartphoneApp {
	
	public static void main(String[] args) throws IOException, NotBoundException{
		
		// Registry holen
		Registry reg = LocateRegistry.getRegistry(1099);
		
		// Stub holen
		TvControllerIF smartTvStub = (TvControllerIF) reg.lookup("SmartTV");
		
		// BL ausführen
		smartTvStub.wechsleKanal(5);
		
		smartTvStub.registriereAufnahmewunsch(new Aufnahmewunsch(Codec.DIVX));
		
		smartTvStub.setAktuelleSendung(new Sendung("Rosarote Pilcher", "Gute Serie"));
		
		System.out.println(smartTvStub.getAktuelleSendung());
	}

}
