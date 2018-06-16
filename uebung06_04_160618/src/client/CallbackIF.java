package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Bericht;

public interface CallbackIF extends Remote {

	public void setBericht(Bericht bericht) throws RemoteException;

}
