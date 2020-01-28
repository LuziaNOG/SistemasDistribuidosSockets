
public class CalcDistribuida{

	public String soma(double a, double b){
		return String.valueOf(a+b);
	}
	public String Sub(double a, double b){
		return String.valueOf(a-b);
	}
	public String Div(double a, double b){
		if (b!=0){
			return String.valueOf(a/b);}
		else {
			return new String("Segundo valor igual a zero, Impossivel Calcular.");
		}
	}
	public String Mult(double a, double b){
		return String.valueOf(a*b);
	}
}
