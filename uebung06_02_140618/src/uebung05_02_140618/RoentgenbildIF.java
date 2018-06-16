package uebung05_02_140618;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface RoentgenbildIF extends Remote{
	
	public Date getAufnahmeVom() throws RemoteException;
	
	public void setPatientenName(String name) throws RemoteException;
	
	public String getPatientenName() throws RemoteException;
	
	public String ausgabe() throws RemoteException;
	
	
	
	


}
