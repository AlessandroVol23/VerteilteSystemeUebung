package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import server.entity.Bericht;
import server.entity.RoentgenbildIF;

public class FrueherkennungsServer implements FrueherkennungsIF {

	@Override
	public Bericht analysiere(RoentgenbildIF bild) throws RemoteException {
		System.out.println("Analysiere Bild...");
		return null;
	}

	public static void main(String[] args) {
		
		try {
			System.out.println("Erstelle Server und Stub.");
			FrueherkennungsIF server = new FrueherkennungsServer();
			FrueherkennungsIF stub = (FrueherkennungsIF) UnicastRemoteObject.exportObject(server, 0);
			
			System.out.println("Erstelle Registry.");
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.bind("LmuFrueherkennungsService", stub);
			
			System.out.println("Warte auf Verbindungen....");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}


}
