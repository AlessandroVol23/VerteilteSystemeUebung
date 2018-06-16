package uebung05_130618;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class UniklinikumRegensburg {
	
	public static void main(String args[]) throws NotBoundException, RemoteException  {
		
		// Registry suchen
		Registry reg = LocateRegistry.getRegistry("localhost", 1099);
		
		// Stub suchen und speichern
		FrueherkennungsIF frueherkennungsDienst = (FrueherkennungsIF)reg.lookup("FrueherkennungsService");
		
		// Business Logic ausführen
		System.out.println("Client: Starte Analyse\n");
		Roentgenbild roentgenBild = new Roentgenbild(new Date(), "Sandro Volpicella");
		System.out.println("Roentgenbild: " + roentgenBild.toString());
		Bericht bericht = frueherkennungsDienst.analysieren(roentgenBild);
		
		System.out.println("Client: Bericht sagt\n" + bericht.toString());
	}

}
