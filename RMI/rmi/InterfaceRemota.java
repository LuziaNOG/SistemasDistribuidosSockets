import java.rmi.Remote;
import java.rmi.RemoteException;


public interface InterfaceRemota extends Remote {

	public String caseRemoto(String palavra) throws RemoteException;

	public String getAviso() throws RemoteException;
}
