package Server;

import Service.Receive;
import Service.Send;
import java.net.*;

import java.io.*;

public class TCPServerMultThread {
    public static void main (String args[]) {
	try{
		int serverPort = 7896; 
		ServerSocket listenSocket = new ServerSocket(serverPort);
		while(true) {
			Socket clientSocket = listenSocket.accept();
			Receive r = new Receive(clientSocket);
			Send s = new Send(clientSocket); 
		}
	} catch(IOException e) {System.out.println("Listen :"+e.getMessage());}
    }
}