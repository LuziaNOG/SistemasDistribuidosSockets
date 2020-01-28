package servidor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Despachante {

	public String invoke(String request) {

		String[] data= request.split(":");
		String op = data[0];
		String novo_data = data[1]+":"+data[2]; 
				
		Class<?> objRef = null;
		Method method = null;
		String resposta = null;
		try {
			objRef = Class.forName("servidor.Esqueleto");
			method = objRef.getMethod(op, String.class);
			resposta = (String) method.invoke(objRef.newInstance(),novo_data);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return resposta;
	}
}