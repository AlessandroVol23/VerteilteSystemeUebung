package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Aufnahmewunsch;
import entity.SendungIF;

public interface TvControllerIF extends Remote {

	public SendungIF getAktuelleSendung() throws RemoteException;

	public void registriereAufnahmewunsch(Aufnahmewunsch wunsch) throws RemoteException;

	public void wechsleKanal(int neuerKanal) throws RemoteException;
	
	public void setAktuelleSendung(SendungIF _sendung) throws RemoteException;

}
