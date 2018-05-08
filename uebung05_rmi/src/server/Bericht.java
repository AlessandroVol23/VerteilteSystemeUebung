package server;

import java.io.Serializable;
import java.util.Date;

public class Bericht implements Serializable {
	
	public Bericht() {
		
	}
	
	private Date datum;
	private String diagnose;
	private String weiteresVorgehen;
	
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public String getDiagnose() {
		return diagnose;
	}
	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}
	public String getWeiteresVorgehen() {
		return weiteresVorgehen;
	}
	public void setWeiteresVorgehen(String weiteresVorgehen) {
		this.weiteresVorgehen = weiteresVorgehen;
	}
	
	

}
