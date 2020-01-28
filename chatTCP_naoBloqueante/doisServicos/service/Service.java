package service;

import java.util.Random;

public class Service {
	static int num = 0;
	static String n = null,q = null;
	int qtd=0;
	
	public String geradorNumAl(String maximo){
		//instância um objeto da classe Random usando o construtor padrão
		Random gerador = new Random();
		int max = Integer.parseInt(maximo);
		num = gerador.nextInt(max);
		n = String.valueOf(num);
		return n;
	}
	
	public String contaL(String msg){
		qtd = msg.length();
		q = String.valueOf(qtd);
		return q;
	}
}
