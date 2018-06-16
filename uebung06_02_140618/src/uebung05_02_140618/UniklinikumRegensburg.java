package uebung05_02_140618;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class UniklinikumRegensburg {

	public static void main(String[] args) throws IOException, NotBoundException {

		// Registry holen
		Registry reg = LocateRegistry.getRegistry(1099);

		// Server Stub holen
		FrueherkennungsIF service = (FrueherkennungsIF) reg.lookup("ErkennungsService");

		// Stub von Entity holen
		Roentgenbild bild = new Roentgenbild("Sandro");
		RoentgenbildIF bildStub = (RoentgenbildIF) UnicastRemoteObject.exportObject(bild, 0);
		System.out.println(bildStub.ausgabe());

		// BL ausführen per Reference
//		bildStub.setPatientenName("Sandro");
		System.out.println("Folgendes Bild wird analysiert von " + bildStub.getPatientenName() + " wird analysiert");
		Bericht bericht = service.analysieren(bildStub);

		System.out.println(bericht.toString());

	}

}
