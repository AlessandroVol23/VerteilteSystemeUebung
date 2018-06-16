package client;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

import entity.BerichtIF;
import entity.Roentgenbild;
import server.FrueherkennungsInterface;

public class UniklinikumRegensburg {

	public static void main(String[] args) throws IOException, NotBoundException {

		// Registry holen
		Registry reg = LocateRegistry.getRegistry("localhost", 1099);
		
		// Server Stub holen
		FrueherkennungsInterface stub = (FrueherkennungsInterface)reg.lookup("ErkennungsService");
		
		// BL 
		BerichtIF bericht = stub.analysieren(new Roentgenbild(new Date(), "Sandro", null));
		
		System.out.println(bericht.ausgabe());
		
	}

}
