package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import server.FrueherkennungsIF;
import server.entity.Roentgenbild;
import server.entity.RoentgenbildIF;

public class UniklinikumRegensburg {

	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			FrueherkennungsIF server = (FrueherkennungsIF) reg.lookup("LmuFrueherkennungsService");
			
			// Erstelle Roentgenbild
			Roentgenbild rBild = new Roentgenbild("Chris");
			
			// Erstelle Bild Stub
			RoentgenbildIF rBildStub = (RoentgenbildIF) UnicastRemoteObject.exportObject(rBild, 0);
			
			System.out.println(rBildStub.ausgabe());

			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
