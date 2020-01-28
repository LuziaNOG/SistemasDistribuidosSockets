import java.rmi.*;
import java.rmi.server.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class InterfaceRemotaServente extends UnicastRemoteObject implements InterfaceRemota {
	
	public InterfaceRemotaServente() throws RemoteException{
		super();
	}

	@Override
	public String caseRemoto(String palavra) throws RemoteException{
		return palavra.toUpperCase();
	}

	@Override
	public String getAviso() throws RemoteException{
		String msg = "Esse programa é um UPPERCASE. Por favor ao executá-lo passe uma palavra como parâmetro.";
		return msg;
	}
}
