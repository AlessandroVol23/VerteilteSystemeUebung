package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class FrueherkennungsServer implements FrueherkennungIF {

	public static void main(String[] args) {
		try {
			System.out.println("Erstelle Stub und Server.");
			FrueherkennungIF server = new FrueherkennungsServer();
			FrueherkennungIF stub = (FrueherkennungIF) UnicastRemoteObject.exportObject(server, 0);
			
			System.out.println("Erstelle Registry.");
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind("LmuFrueherkennungsServer", stub);
			
			System.out.println("Server bereit!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Bericht analysieren(Roentgenbild bild) {
		System.out.println("Analysiere Bericht...");
		return null;
	}

}
