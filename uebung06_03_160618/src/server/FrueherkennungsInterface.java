package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.BerichtIF;
import entity.Roentgenbild;

public interface FrueherkennungsInterface extends Remote{
	
	public BerichtIF analysieren(Roentgenbild bild) throws RemoteException;
	
	

}
