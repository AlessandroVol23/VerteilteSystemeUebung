package uebung05_02_140618;

/*
 * Teilaufgabe 02: Roentgenbild Call by Reference
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FrueherkennungsIF extends Remote{
	
	public Bericht analysieren(RoentgenbildIF bild) throws RemoteException;

}
