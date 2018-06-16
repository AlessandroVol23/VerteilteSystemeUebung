package uebung05_01_140618;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class UniklinikumRegensburg {

	
	public static void main(String[] args) throws IOException, NotBoundException{
		
		
		// Registry holen
		Registry reg = LocateRegistry.getRegistry("localhost", 1099);
		
		// Stub holen
		FrueherkennungsIF frueherkennungsService = (FrueherkennungsIF)reg.lookup("ErkennungsService");
		
		// BL ausführen
		Bericht bericht = frueherkennungsService.analysiere(new Roentgenbild(new Date(), "sandro"));
		
		System.out.println("Bericht analysiert.\nErgebnis:" + bericht.toString());
		
		
	}
}
