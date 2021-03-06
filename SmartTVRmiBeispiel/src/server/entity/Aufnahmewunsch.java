package server.entity;

import java.rmi.RemoteException;
import java.util.Date;

import server.AufnahmeWunschIF;

public class Aufnahmewunsch implements AufnahmeWunschIF {

	private Date startZeitpunkt = new Date();
	private Date endZeitpunkt = new Date();
	private Codec codec = Codec.MPEG4;

	public Aufnahmewunsch() {
		super();
	}

	@Override
	public Date getStartZeitpunkt() throws RemoteException {
		System.out.println("Aufnahmewunsch: getStart aufgerufen");
		return startZeitpunkt;
	}

	public void setStartZeitpunkt(Date startZeitpunkt) {
		this.startZeitpunkt = startZeitpunkt;
	}

	@Override
	public Date getEndZeitpunkt() throws RemoteException {
		System.out.println("Aufnahmewunsch: getEnde aufgerufen");
		return endZeitpunkt;
	}

	public void setEndZeitpunkt(Date endZeitpunkt) {
		this.endZeitpunkt = endZeitpunkt;
	}

	@Override
	public Codec getCodec() throws RemoteException {
		System.out.println("Aufnahmewunsch: getCodec aufgerufen");
		return codec;
	}

	public void setCodec(Codec codec) {
		this.codec = codec;
	}

	@Override
	public String ausgabe() {
		System.out.println("Aufnahmewunsch: ausgabe() aufgerufen");
		return "Aufnahmewunsch [startZeitpunkt=" + startZeitpunkt + ", endZeitpunkt=" + endZeitpunkt + ", codec="
				+ codec + "]";
	}

}
