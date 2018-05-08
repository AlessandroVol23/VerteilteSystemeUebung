package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.entity.Bericht;
import server.entity.RoentgenbildIF;

public interface FrueherkennungsIF extends Remote{
	
	public Bericht analysiere(RoentgenbildIF bild) throws RemoteException;


}
