package server.entity;

import java.io.Serializable;
import java.util.Date;

public class Bericht implements Serializable {
	
	private Date datum = new Date();
	private String diagnose;
	private String weiteresVorgehen;

}
