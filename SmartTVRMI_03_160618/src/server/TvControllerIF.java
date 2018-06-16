package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.AufnahmewunschIF;
import entity.Sendung;

public interface TvControllerIF extends Remote {

	public Sendung getAktuelleSendung() throws RemoteException;

	public void registriereAufnahmewunsch(AufnahmewunschIF wunsch) throws RemoteException;

	public void wechsleKanal(int neuerKanal) throws RemoteException;
	
	public void setAktuelleSendung(Sendung _sendung) throws RemoteException;

}
