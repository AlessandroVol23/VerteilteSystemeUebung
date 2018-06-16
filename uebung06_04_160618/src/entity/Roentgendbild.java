package entity;

import java.io.Serializable;
import java.util.Date;

public class Roentgendbild implements Serializable{
	
	private Date aufnahmeVom;
	private transient String patientenName;
	private byte[] rawData;
	
	public Roentgendbild(Date aufnahmeVom, String patientenName) {
		super();
		this.aufnahmeVom = aufnahmeVom;
		this.patientenName = patientenName;
	}

	@Override
	public String toString() {
		return "Roentgendbild [aufnahmeVom=" + aufnahmeVom + ", patientenName=" + patientenName + "]";
	}
	
	
	
	

}
