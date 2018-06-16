package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CallbackIF extends Remote{
	
	public void aufnahmeFertig(String pfadZuVideo) throws RemoteException;

}
