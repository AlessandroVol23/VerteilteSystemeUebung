package server;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import server.entity.Bericht;
import server.entity.Roentgenbild;

public class FrueherkennungsServer implements FrueherkennungsIF {

	public static void main(String[] args) {
		try {
			FrueherkennungsServer server = new FrueherkennungsServer();
			FrueherkennungsIF stub = (FrueherkennungsIF) UnicastRemoteObject.exportObject(server, 0);

			Registry reg = LocateRegistry.createRegistry(1099);
			reg.bind("LmuErkennungsService", stub);
			
			System.out.println("Server gestartet!...");

		} catch (RemoteException e) {
			e.printStackTrace();

		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Bericht analysieren(Roentgenbild bild) throws RemoteException {
		System.out.println("Server: Analysiere Bild...");
		Bericht bericht = new Bericht("Schaut ois guad aus", "Goar nix");
		return bericht;
	}

}
