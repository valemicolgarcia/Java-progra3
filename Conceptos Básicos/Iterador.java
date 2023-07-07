package practica2;

public class Iterador {
	
	
	//-----------METODOS DE INSTANCIA---------------
	
	public void iteracionConFor (int a, int b) {
		//metodo de instancia
		for (int i= a; i<=b; i++ )
				System.out.println (i);
	}

	public void iteracionConWhile (int a, int b) {
		//metodo de instancia
		while (a<=b) {
			System.out.println (a);
			a++;
		}
	}

	public void recursivo (int a, int b) {
		//metodo de instancia
		if (a <= b) {
			System.out.println (a);
			a++;
			recursivo (a,b);
		}
	}
	
	//-----------METODOS DE CLASE------------------
	
	public static void iteracionConFor2 (int a, int b) {
		for (int i= a; i<=b; i++ )
			System.out.println (i);
	}
	
	public static void iteracionConWhile2 (int a, int b) {
		
		while (a<=b) {
			System.out.println (a);
			a++;
			}
		}
	
	public static void recursivo2 (int a, int b) {
		
		if (a <= b) {
			System.out.println (a);
			a++;
			recursivo2 (a,b);
		}
	}
	
	//-----------------fin-----------------------
}