package server.entity;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Date;

public class Roentgenbild implements RoentgenbildIF{
	
	private Date aufnahmeVom = new Date();
	private String patientenName = "Horst";
	private byte[] rawData;
	
	public Roentgenbild(String name) {
		this.patientenName = name;
	}
	
	
	
	public Date getAufnahmeVom() {
		return aufnahmeVom;
	}



	public void setAufnahmeVom(Date aufnahmeVom) {
		this.aufnahmeVom = aufnahmeVom;
	}



	public String getPatientenName() {
		return patientenName;
	}



	public void setPatientenName(String patientenName) {
		this.patientenName = patientenName;
	}



	public byte[] getRawData() {
		return rawData;
	}



	public void setRawData(byte[] rawData) {
		this.rawData = rawData;
	}



	@Override
	public String ausgabe() {
		System.out.println("Roentgendbild: Sende Ausgabe zu Client");
		return "Roentgenbild [aufnahmeVom=" + aufnahmeVom + ", patientenName=" + patientenName + ", rawData="
				+ Arrays.toString(rawData) + "]";
	}
	
	



}
