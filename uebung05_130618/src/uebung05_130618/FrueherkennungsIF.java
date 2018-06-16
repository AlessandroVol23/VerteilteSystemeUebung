package uebung05_130618;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FrueherkennungsIF extends Remote {
	
	public Bericht analysieren(Roentgenbild roentgenBild) throws RemoteException;
	

}
