package server;

import java.io.Serializable;
import java.util.Date;

public class Roentgenbild implements Serializable {

	private Date aufnahmeVom;
	private transient String patientenName;
	private byte[] rawData;

}
