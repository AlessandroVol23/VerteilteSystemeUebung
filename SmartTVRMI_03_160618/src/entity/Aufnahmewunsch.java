package entity;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Date;

public class Aufnahmewunsch implements AufnahmewunschIF {

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

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Codec getCodec() {
		return codec;
	}

	public void setCodec(Codec codec) {
		this.codec = codec;
	}

	@Override
	public String ausgabe() throws RemoteException {
		String ausgabe = "Start: " + this.start + "\nEnd: " + this.end + "\nCodec: " + this.codec;
		return ausgabe;
	}

}
