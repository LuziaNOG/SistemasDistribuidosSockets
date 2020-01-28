package user;

import java.io.BufferedReader; 

import java.io.IOException;
import java.io.InputStreamReader;

import client.TCPClient;

public class User {

	public static void main(String args[]) throws IOException {
		String serv = "0", resp = null, msgC= null;
		TCPClient cl = new TCPClient();
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digite o que desejar: ");
		msgC = stdin.readLine();
		cl.sendRequest(msgC);
		resp = cl.getResponse();
		System.out.println(resp);
	}
}
