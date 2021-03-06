package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

import server.entity.Codec;

public interface AufnahmeWunschIF extends Remote {

	public Date getStartZeitpunkt() throws RemoteException;

	public Date getEndZeitpunkt() throws RemoteException;

	public Codec getCodec() throws RemoteException;
	
	public String ausgabe() throws RemoteException;
}
