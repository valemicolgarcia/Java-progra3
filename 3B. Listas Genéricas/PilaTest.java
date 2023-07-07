package prog3.util;

public class PilaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Pila <Character> p = new Pila <Character>();
		
		p.apilar('a');
		p.apilar('b');
		p.apilar('c');
		p.apilar('d');
		p.apilar('e');
		
		for (int i= 0; i<4; i++) {
			p.desapilar();
		}
		
		System.out.println(p.tope());
		
		

		
	}

}
