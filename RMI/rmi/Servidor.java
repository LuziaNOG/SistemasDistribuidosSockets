import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
	public static void main(String args[]){
         System.setSecurityManager(new SecurityManager());
        try{
            InterfaceRemota refServente = new InterfaceRemotaServente();
			
            Naming.rebind("//localhost/InterfaceRemota", refServente); 
            System.out.println("Servidor em Execução");
        }catch(Exception e) {
            System.out.println("ERRO!!!!! " + e.getMessage());
        }
    }
}
