package entity;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface SendungIF extends Remote {

	public String getName() throws RemoteException;

	public String getBeschreibung() throws RemoteException;

	public Date getStartzeitpunkt() throws RemoteException;

	public Date getEndzeitpunkt() throws RemoteException;

	public void setName(String _name) throws RemoteException;

	public void setBeschreibung(String _beschreibung) throws RemoteException;

	public void setStartzeitpunkt(Date _start) throws RemoteException;

	public void setEndzeitpunkt(Date _end) throws RemoteException;
	
	public String ausgabe() throws RemoteException;

}
