package client;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import entity.Bericht;
import entity.Roentgendbild;
import server.FrueherkennungsIF;

public class UniklinikumRegensburg implements CallbackIF {

	private static Bericht bericht;
	
	public static void main(String[] args) throws IOException, NotBoundException{
		// Registry holen
		Registry reg = LocateRegistry.getRegistry("localhost", 1099);
		
		// Server Stub holen
		FrueherkennungsIF stub = (FrueherkennungsIF) reg.lookup("ErkennungsService");
		
		// Callback Stub erstellen
		CallbackIF c = new UniklinikumRegensburg();
		CallbackIF cStub = (CallbackIF) UnicastRemoteObject.exportObject(c, 0);
		
		// BL ausführen
		stub.analysieren(new Roentgendbild(new Date(), "Sandro"), c);
		
		// Bericht aufrufen lokal
		System.out.println(bericht.toString());
	}

	@Override
	public void setBericht(Bericht _bericht) throws RemoteException {
		this.bericht = _bericht;
	}

}
