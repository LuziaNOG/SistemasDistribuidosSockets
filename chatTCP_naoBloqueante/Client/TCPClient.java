package Client;

import java.net.*;
import Service.Receive;
import Service.Send;

import java.io.*;
public class TCPClient {
	public static void main (String args[]) {
	// arguments supply message and hostname of destination
	Socket s = null;
	    try{
	    	int serverPort = 7896;
		   	s = new Socket("127.0.0.1", serverPort);
		   	Send envia = new Send(s);
		   	Receive recebe = new Receive(s);
		   	
	    } catch (IOException e){ System.out.println("IO:"+e.getMessage());
		}
  	}
}