package server;

import java.net.*;

import client.TCPClient;
import service.Service;

import java.io.*;
public class TCPServer {

	public static void main (String args[]) {
		try{
			int serverPort = 7896; // the server port
			ServerSocket listenSocket = new ServerSocket(serverPort);
			while(true) {
				Socket clientSocket = listenSocket.accept();
				Connection c = new Connection(clientSocket);
			}
		} catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
	}
}
class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	public Connection (Socket aClientSocket) {
		try {
			clientSocket = aClientSocket;
			in = new DataInputStream( clientSocket.getInputStream());
			out =new DataOutputStream( clientSocket.getOutputStream());
			this.start();
		} catch(IOException e) {System.out.println("Connection:"+e.getMessage());}
	}

	public void getRequest(){
		String n = null;
		try {
			n = in.readUTF();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void sendResponse(String request){
		
		try {
			out.writeUTF(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run(){
		String resp = null,respC = null;
		try {			                 // an echo server
			Service c = new Service();
			String msgC = in.readUTF();	                  // read a line of data from the stream
			
			 if (msgC.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
				 respC=c.contaL(msgC);
				 sendResponse(respC);
			 }
			 else if (msgC.matches("^[0-9]*$")) {
				 respC=c.geradorNumAl(msgC);
				 sendResponse(respC); 
			 }
			 else
			     System.out.println("ERRO");
						
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		} catch(IOException e) {System.out.println("readline:"+e.getMessage());
		} finally{ try {System.out.println("up"); clientSocket.close();}catch (IOException e){/*close failed*/}}
	}
}
