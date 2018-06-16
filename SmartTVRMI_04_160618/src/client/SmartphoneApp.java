package client;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.security.auth.callback.Callback;

import entity.Aufnahmewunsch;
import entity.Codec;
import entity.Sendung;
import server.TvControllerIF;

public class SmartphoneApp implements CallbackIF{
	
	public static void main(String[] args) throws IOException, NotBoundException{
		
		// Registry holen
		Registry reg = LocateRegistry.getRegistry(1099);
		
		// Stub holen
		TvControllerIF smartTvStub = (TvControllerIF) reg.lookup("SmartTV");
		
		// Client Stub erstellen
		CallbackIF callback = new SmartphoneApp();
		CallbackIF callbackStub = (CallbackIF) UnicastRemoteObject.exportObject(callback,0);
		
		
		// BL ausführen
		
		smartTvStub.aufnehmen(callbackStub);
		
//		
//		smartTvStub.wechsleKanal(5);
//		
//		smartTvStub.registriereAufnahmewunsch(new Aufnahmewunsch(Codec.DIVX));
//		
//		smartTvStub.setAktuelleSendung(new Sendung("Rosarote Pilcher", "Gute Serie"));
//		
//		System.out.println(smartTvStub.getAktuelleSendung());
	}

	@Override
	public void aufnahmeFertig(String pfadZuVideo) throws RemoteException {
		System.out.println("Pfad von Server erhalten: " + pfadZuVideo);
		
	}

}
