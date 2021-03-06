package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.Bericht;
import server.FrueherkennungIF;
import server.Roentgenbild;

public class TestClient {

	public static void main(String[] args) {

		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			FrueherkennungIF server = (FrueherkennungIF) registry.lookup("LmuErkennungsServer");
			
			Bericht bericht = server.analysieren(new Roentgenbild());
			
			System.out.println("Client hat gesendet.");
			

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
