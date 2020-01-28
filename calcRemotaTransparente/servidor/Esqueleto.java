package servidor;

import util.Calculadora;

public class Esqueleto {

	Calculadora calc = Calculadora.getInstance();
	
	public String add(String msg) {
		String[] n = msg.split(":");
		double n1 = Double.parseDouble(n[0]);
		double n2 = Double.parseDouble(n[1]);
		
		return Double.toString(calc.add(n1, n2));
	}
	
	public String sub(String msg) {
		String[] n = msg.split(":");
		double n1 = Double.parseDouble(n[0]);
		double n2 = Double.parseDouble(n[1]);
		
		return Double.toString(calc.sub(n1, n2));
	}
	
	public String mult(String msg) {
		String[] n = msg.split(":");
		double n1 = Double.parseDouble(n[0]);
		double n2 = Double.parseDouble(n[1]);
		
		return Double.toString(calc.mult(n1, n2));
	}
	
	public String div(String msg) {
		String[] n = msg.split(":");
		double n1 = Double.parseDouble(n[0]);
		double n2 = Double.parseDouble(n[1]);
		
		return Double.toString(calc.div(n1, n2));
	}
}