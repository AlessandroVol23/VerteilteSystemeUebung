package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import server.FrueherkennungsIF;
import server.entity.Roentgenbild;

public class UniklinikumRegensburg implements CallbackReferenceIF {

	public static void main(String[] args) {
		try {
			// Registry finden
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);

			// Stub in Registry finden
			FrueherkennungsIF stub = (FrueherkennungsIF) reg.lookup("LmuErkennungsService");
			
			// Callback Referenz erstellen
			UniklinikumRegensburg callback = new UniklinikumRegensburg();
			
			// Callback Referenz in Stub umwandeln
			CallbackReferenceIF callbackStub = (CallbackReferenceIF)UnicastRemoteObject.exportObject(callback, 0);
			
			System.out.println("Will Bild analysieren!");
			// BL ausf�hren
			stub.analysieren(new Roentgenbild(), callbackStub);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void setBestaetigung(Boolean b) throws RemoteException {
		if(b) {
			System.out.println("Wurde best�tigt! Bild ist analyisiert");			
		}
	}

}
