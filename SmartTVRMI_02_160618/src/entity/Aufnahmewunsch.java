package entity;

import java.io.Serializable;
import java.util.Date;

public class Aufnahmewunsch implements Serializable{
	
	private Date start;
	private Date end;
	private Codec codec;
	
	
	
	public Aufnahmewunsch(Codec codec) {
		super();
		this.start = new Date();
		this.end = new Date();
		this.codec = codec;
	}



	@Override
	public String toString() {
		return "Aufnahmewunsch [start=" + start + ", end=" + end + ", codec=" + codec + "]";
	}
	
	

}
