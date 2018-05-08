package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.entity.Aufnahmewunsch;
import server.entity.Sendung;

public interface TvControllerIF extends Remote {
	
	Sendung getAktuelleSendung() throws RemoteException;
	void registriereAufnahmewunsch(AufnahmeWunschIF aufnahmewunsch) throws RemoteException;
	void wechsleKanal(int neuerKanal) throws RemoteException;

}
