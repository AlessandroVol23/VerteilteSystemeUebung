package entity;

import java.io.Serializable;
import java.util.Date;

public class Bericht implements Serializable{
	
	private Date datum;
	private String diagnose;
	private String weiteresVorgehen;
	
	public Bericht(Date datum, String diagnose, String weiteresVorgehen) {
		super();
		this.datum = datum;
		this.diagnose = diagnose;
		this.weiteresVorgehen = weiteresVorgehen;
	}

	@Override
	public String toString() {
		return "Bericht [datum=" + datum + ", diagnose=" + diagnose + ", weiteresVorgehen=" + weiteresVorgehen + "]";
	}
	
	
	
	

}
