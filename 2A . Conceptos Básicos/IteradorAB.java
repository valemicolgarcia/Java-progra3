package practica2;

public class IteradorAB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//instancio la clase iterador
		Iterador i = new Iterador();
		
		//llamo a metodos de instancia 
		//imprime con for 
		int a = 1;
		int b = 5;
		System.out.println ("Métodos de instancia:");
		
		System.out.println ("IMPRIME CON FOR");
		i.iteracionConFor (a,b);
		//
		System.out.println ("IMPRIME CON WHILE");
		i.iteracionConWhile (a,b);
		//
		System.out.println ("IMPRIME RECURSIVO");
		i.recursivo(a,b);
		//
		System.out.println ("    ");
		System.out.println (" ------------------- ");
		System.out.println ("    ");
		
		System.out.println ("Métodos de clase:");
		
		//llamo a metodo de clase, con: el nombre de la clase . metodo a usar
		System.out.println ("IMPRIME CON FOR 2 ");
		Iterador.iteracionConFor2 (a,b);
		
		System.out.println ("IMPRIME CON WHILE 2");
		Iterador.iteracionConWhile2 (a,b);
		
		System.out.println ("IMPRIME RECURSIVO 2");
		Iterador.recursivo2 (a,b);
		
		
		}
	}


