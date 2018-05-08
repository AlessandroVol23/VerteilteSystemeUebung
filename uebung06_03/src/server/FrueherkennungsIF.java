package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.entity.Bericht;
import server.entity.Roentgenbild;

public interface FrueherkennungsIF extends Remote{
	
	public Bericht analysieren(Roentgenbild bild) throws RemoteException;

}
