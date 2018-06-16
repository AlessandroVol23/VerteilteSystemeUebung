package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.CallbackIF;
import entity.Bericht;
import entity.Roentgendbild;

public interface FrueherkennungsIF extends Remote{
	
	public void analysieren(Roentgendbild bild, CallbackIF referenz) throws RemoteException;

}
