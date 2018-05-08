package server.entity;

import java.io.Serializable;
import java.util.Date;

public class Roentgenbild implements Serializable {
	
	private Date aufnahmeVon = new Date();
	private transient String patientenName = "Horst";
	private byte[] rawData;

}
