package entity;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface AufnahmewunschIF extends Remote {

	public Date getStart() throws RemoteException;

	public void setStart(Date start) throws RemoteException;

	public Date getEnd() throws RemoteException;

	public void setEnd(Date end) throws RemoteException;

	public Codec getCodec() throws RemoteException;

	public void setCodec(Codec codec) throws RemoteException;
	
	public String ausgabe() throws RemoteException;
}
