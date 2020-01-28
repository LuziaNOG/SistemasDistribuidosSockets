package proxy;

import cliente.ClienteTcp;


public class Proxy {
	
	ClienteTcp cliente = new ClienteTcp();
	String msg = null;
	
	public double add(double n1, double n2) {
		msg ="add:" + Double.toString(n1) + ":" + Double.toString(n2); 
		cliente.sendRequest(msg);
		return Double.parseDouble(cliente.getResponse());
	}
	
	public double sub(double n1, double n2) {
		
		msg ="sub:" + n1 + ":" + n2; 
		cliente.sendRequest(msg);
		return Double.parseDouble(cliente.getResponse());
	}
	
	public double mult(double n1, double n2) {
		
		msg ="mult:" + n1 + ":" + n2; 
		cliente.sendRequest(msg);
		return Double.parseDouble(cliente.getResponse());
	}
	
	public double div(double n1, double n2) {
		
		msg ="div:" + n1 + ":" + n2; 
		cliente.sendRequest(msg);
		return Double.parseDouble(cliente.getResponse());
	}
}