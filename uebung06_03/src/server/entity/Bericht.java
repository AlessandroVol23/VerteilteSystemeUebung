package server.entity;

import java.rmi.RemoteException;
import java.util.Date;

public class Bericht implements BerichtIF {

	private Date datum = new Date();
	private String diagnose;
	private String weiteresVorgehen;

	public Bericht(String diagnose, String weiteresVorgehen) {
		super();
		this.diagnose = diagnose;
		this.weiteresVorgehen = weiteresVorgehen;
	}

	public Date getDatum() throws RemoteException {
		System.out.println("Sende Datum...");
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getDiagnose() throws RemoteException {
		System.out.println("Sende Diagnose...");
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getWeiteresVorgehen() throws RemoteException {
		System.out.println("Sende weiteres Vorgehen...");
		return weiteresVorgehen;
	}

	public void setWeiteresVorgehen(String weiteresVorgehen) {
		this.weiteresVorgehen = weiteresVorgehen;
	}

	@Override
	public String ausgabe() throws RemoteException{
		System.out.println("Sende Ausgabe...");
		return "Bericht [datum=" + datum + ", diagnose=" + diagnose + ", weiteresVorgehen=" + weiteresVorgehen + "]";
	}

}
