package prog3.util;

public class ColaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ColaGenerica <Integer>cola = new ColaGenerica <Integer>();
		
		cola.encolar(1);
		cola.encolar(3);
		cola.encolar(5);
		cola.encolar(7);
		cola.encolar(9);
		
		System.out.println("DESENCOLO UNO --> " + cola.desencolar());
	
		
		
		
		
	}

}
