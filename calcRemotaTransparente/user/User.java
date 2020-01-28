package user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import proxy.Proxy;


public class User {
	public static void main(String args[]) throws IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		Proxy pr = new Proxy();
		
		System.out.println("Escolha sua operação 1-add, 2-sub, 3-mult ou 4-div");
		String op = teclado.readLine();
		System.out.println("Informe o primeiro numero");
		String n1 = teclado.readLine();
		System.out.println("Informe o segundo numero");
		String n2 = teclado.readLine();
		
		
		switch (op) {
		case "1":
			System.out.println("Servidor: " + pr.add(Double.parseDouble(n1), Double.parseDouble(n2)));
			break;
		case "2":
			System.out.println("Servidor: " + pr.sub(Double.parseDouble(n1), Double.parseDouble(n2)));
			break;
		case "3":
			System.out.println("Servidor: " + pr.mult(Double.parseDouble(n1), Double.parseDouble(n2)));
			break;
		case "4":
			System.out.println("Servidor: " + pr.div(Double.parseDouble(n1), Double.parseDouble(n2)));
			break;
		default:
			System.out.println("Erro");
			break;
		}

	}
}