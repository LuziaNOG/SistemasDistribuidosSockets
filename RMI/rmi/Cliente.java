import java.rmi.*;
import java.rmi.server.*;


public class Cliente{
	public static void main(String args[]){
	
		if(System.getSecurityManager() == null){
			System.setSecurityManager(new SecurityManager());
		} else System.out.println("Ja tem um gerenciador de seg ativo");
		
		InterfaceRemota refRemota = null;
		String palavra="";
		int caso=0;

		if (args.length > 0){
			palavra = args[0];
			caso=1;
		}

		String resposta = "";
		
		try{

			refRemota = (InterfaceRemota) Naming.lookup("//localhost/InterfaceRemota");
			switch (caso){
				case 0:
					resposta = refRemota.getAviso();
					break;
				case 1:
					resposta = refRemota.caseRemoto(palavra);
					break;
				default:
					System.out.println("Erro no switch");
			}
			System.out.println("Resposta: " + resposta);
		}catch(RemoteException e) {System.out.println("allShapes: " + e.getMessage());
		}catch(Exception e) {System.out.println("Lookup: " + e.getMessage());}
	}
}



