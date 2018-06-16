package uebung05_01_140618;

import java.io.Serializable;
import java.util.Date;

public class Roentgenbild implements Serializable{
	
	private Date aufnahmeVom;
	private transient String patientenName;
	private byte[] rawData;
	

	
	public Roentgenbild(Date aufnahmeVom, String patientenName) {
		super();
		this.aufnahmeVom = aufnahmeVom;
		this.patientenName = patientenName;
	}



	@Override
	public String toString() {
		return "Roentgenbild [aufnahmeVom=" + aufnahmeVom + ", patientenName=" + patientenName + "]";
	}


	
	

}
