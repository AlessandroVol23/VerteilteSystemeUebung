package entity;

import java.rmi.RemoteException;
import java.util.Date;

public class Bericht implements BerichtIF {

	private Date date;
	private String diagnose;
	private String weiteresVorgehen;

	public Bericht(Date date, String diagnose, String weiteresVorgehen) {
		this.date = date;
		this.diagnose = diagnose;
		this.weiteresVorgehen = weiteresVorgehen;
	}

	@Override
	public Date getDate() throws RemoteException {
		// TODO Auto-generated method stub
		return this.date;
	}

	@Override
	public void setDate(Date _date) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDiagnose() throws RemoteException {
		// TODO Auto-generated method stub
		return this.diagnose;
	}

	@Override
	public void setDiagnose(String _diagnose) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getWeiteresVorgehen() throws RemoteException {
		// TODO Auto-generated method stub
		return this.weiteresVorgehen;
	}

	@Override
	public void setWeiteresVorgehen(String _weiteresVorgehen) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public String ausgabe() throws RemoteException {
		String ausgabe = "Datum: " + this.date + "\nDiagnose: " + this.diagnose + "\nWeiteres Vorgehen: "
				+ this.weiteresVorgehen;
		return ausgabe;
	}

}
