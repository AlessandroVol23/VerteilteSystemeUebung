package entity;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface BerichtIF extends Remote {

	public Date getDate() throws RemoteException;

	public void setDate(Date _date) throws RemoteException;

	public String getDiagnose() throws RemoteException;

	public void setDiagnose(String _diagnose) throws RemoteException;

	public String getWeiteresVorgehen() throws RemoteException;

	public void setWeiteresVorgehen(String _weiteresVorgehen) throws RemoteException;
	
	public String ausgabe() throws RemoteException;

}
