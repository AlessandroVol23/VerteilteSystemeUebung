package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class FrueherkennungsServer implements FrueherkennungIF {

	public static void main(String[] args) {

		try {
			System.out.println("Instanz und Stub generieren.");
			FrueherkennungsServer frueherkennungsServer = new FrueherkennungsServer();
			FrueherkennungIF stub = (FrueherkennungIF) UnicastRemoteObject.exportObject(frueherkennungsServer, 0);
			
			System.out.println("An Registry binden.");
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind("LmuErkennungsServer", stub);
			
			System.out.println("Server ist bereit!");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Bericht analysieren(Roentgenbild rb) {

		System.out.println("Analysiere Bericht ...");

		return null;
	}

}
