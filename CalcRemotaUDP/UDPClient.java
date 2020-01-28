import java.net.*;
import java.io.*;
public class UDPClient{
	public static void main(String [] args){ 
		// args give message contents and destination hostname
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket aSocket = null;
		String op=null,a=null,b = null;
		try {
			System.out.printf("Informe o primeiro valor:");
			a = stdin.readLine();
			System.out.printf("Informe a operação +,-,*,/");
			op = stdin.readLine();
			System.out.printf("Informe o segundo valor: ");
			b = stdin.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String entrada =(a+":"+op+":"+b);
		
		try {
			aSocket = new DatagramSocket();    
			byte [] m = entrada.getBytes();
			InetAddress aHost = InetAddress.getByName("localhost");
			int serverPort = 6789;		                                                 
			DatagramPacket request =
					new DatagramPacket(m,  entrada.length(), aHost, serverPort);
			aSocket.send(request);			                        
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	
			aSocket.receive(reply);
			System.out.println("Reply: " + new String(reply.getData()));	
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e){System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null) aSocket.close();}
	}		      	
}
