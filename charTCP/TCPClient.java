import java.net.*;
import java.io.*;
public class TCPClient {
	public static void main (String args[]) {
		// arguments supply message and hostname
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String msgEnviada = null, msgRecebida=null;
		Socket s = null;
		try{
			int serverPort = 7896;
			s = new Socket("localhost", serverPort);    
			DataInputStream in = new DataInputStream( s.getInputStream());
			DataOutputStream out =new DataOutputStream( s.getOutputStream());
			
			while(true) {
			System.out.println("Maquina1: Escreva a sua mensagem");
			msgEnviada = stdin.readLine();
			out.writeUTF(msgEnviada);      	// UTF is a string encoding see Sn. 4.4
			msgRecebida = in.readUTF();	    // read a line of data from the stream
			System.out.println("Maquina1: Mensagem recebida: "+msgRecebida);
			}
						
		}catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		}catch (IOException e){System.out.println("readline:"+e.getMessage());
		}finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
     }
}

