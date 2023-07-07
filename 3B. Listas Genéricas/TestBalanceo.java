package prog3.util;



public class TestBalanceo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String palabra = "{(Hola}";
		System.out.println("La palabra a analizar es: " + palabra);
		System.out.println("Esta balanceada?, la respuesta es: " + Balanceado (palabra));
	}

	
	public static boolean Balanceado (String palabra) {
		Pila <Character> pila = new Pila <Character> ();
		boolean verificado= false;
		char c2;
		
		for (int i=0; i < palabra.length(); i++) {
			char c = palabra.charAt(i); //veo cual es el primer caracter de la palabra
			if ( (c== '{') || (c== '[') || (c == '(') ) {
				pila.apilar(c);
			}
			else {
				if ( (c== '}') || (c== ']') || (c == ')') ) {
					c2 = pila.desapilar();
					if (( (c2 =='{') && (c == '}') ) || ( (c2 =='(') && (c == ')') ) || ( (c2 =='[') && (c == ']') ))
						verificado = true;
				}
			}
		}
	
		return verificado;
	}
	
	
	
	
	
}
