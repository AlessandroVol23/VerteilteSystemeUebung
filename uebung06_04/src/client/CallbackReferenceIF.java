package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CallbackReferenceIF extends Remote {
	
	public void setBestaetigung(Boolean b) throws RemoteException;

}