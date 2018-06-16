package uebung05_01_140618;

/*
 * 1. Interface definieren
 * 2. Server implementieren
 * 3. Entitys festlegen
 * 4. Server Stub erstellen und registrieren
 * 5. Client implementieren, Stub holen und aufrufen
 * 
 * 
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FrueherkennungsIF extends Remote{
	
	public Bericht analysiere(Roentgenbild bild) throws RemoteException;

}
