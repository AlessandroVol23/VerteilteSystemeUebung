package uebung05_02_140618;

import java.rmi.RemoteException;
import java.util.Date;

public class Roentgenbild implements RoentgenbildIF {

	private Date aufnahmeVom;
	private String patientenName;
	private byte[] rawData;

	public Roentgenbild(String patientenName) {
		super();
		this.aufnahmeVom = new Date();
		this.patientenName = patientenName;
	}

	@Override
	public String toString() {
		return "Roentgenbild [aufnahmeVom=" + aufnahmeVom + ", patientenName=" + patientenName + "]";
	}

	@Override
	public Date getAufnahmeVom() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPatientenName() throws RemoteException {
		return this.patientenName;
	}

	@Override
	public void setPatientenName(String name) throws RemoteException {
		this.patientenName = name;
	}

	@Override
	public String ausgabe() throws RemoteException {
		System.out.println("Sende Ausgabe an Server");
		String ausgabe = "Name is: " + this.patientenName + "\nDate is: " + this.aufnahmeVom;
		return ausgabe;
	}
	
	

}
