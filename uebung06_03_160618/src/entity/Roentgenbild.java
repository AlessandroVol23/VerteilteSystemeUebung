package entity;

import java.io.Serializable;
import java.util.Date;

public class Roentgenbild implements Serializable{
	
	private Date aufnahmeVom;
	private transient String patientenName;
	private byte[] rawData;
	
	public Roentgenbild(Date aufnahmeVom, String patientenName, byte[] rawData) {
		super();
		this.aufnahmeVom = aufnahmeVom;
		this.patientenName = patientenName;
		this.rawData = rawData;
	}
	
	@Override
	public String toString() {
		return "Roentgenbild [aufnahmeVom=" + aufnahmeVom + ", patientenName=" + patientenName + "]";
	}
	
	
	
	

}
