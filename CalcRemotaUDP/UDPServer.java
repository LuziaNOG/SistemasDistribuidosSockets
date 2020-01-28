import java.net.*; 
import java.io.*;
import java.util.*;
public class UDPServer{
	public static void main(String[] args){ 
		CalcDistribuida calc = new CalcDistribuida();
		DatagramSocket aSocket = null;
		String result = null;
		try{
			aSocket = new DatagramSocket(6789);
			// create socket at agreed port
			byte[] buffer = new byte[1000];
			while(true){
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				String dados = new String(request.getData());
				String op[] = dados.split(":");
				String operador = op[1];
				double a = Double.parseDouble(op[0]); 
				double b = Double.parseDouble(op[2]);
				
				switch (operador){
				
				case "+":
					result = calc.soma(a,b);
					break;
				case "-":
					result = calc.Sub(a, b);
					break;
				case "*":
					result = calc.Mult(a, b);
					break;
				case "/":
					result = calc.Div(a, b);
					break;
				default:
					System.out.println("erro");
					break;
				}
				
				
					DatagramPacket reply = new DatagramPacket(result.getBytes(), result.length(), 
							request.getAddress(), request.getPort());
					aSocket.send(reply);
				}
			}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
			}catch (IOException e) {System.out.println("IO: " + e.getMessage());
			}finally {if(aSocket != null) aSocket.close();}
		}
	}
