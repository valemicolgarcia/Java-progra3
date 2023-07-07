package prog3.listaenteros;



public class ListaDeEnterosEnlazadaTestBasico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada (); //instancio
		
		l.agregarFinal(3);
		l.agregarFinal(5);
		l.agregarFinal(1);
		imprimir (l);
		System.out.println("IMPRIME LA LISTA ORDENADA");
		imprimirReves (l);
		
		
		
	}
	
	


private static void imprimir (ListaDeEnterosEnlazada lista) {
		
		// RECORRIDO DE UNA LISTA //usar este!!!!!!!!!
		lista.comenzar(); //siempre poner esto, hago que el puntero apunte al inicio
		while (!lista.fin()) { //mientras no llegue al final
			System.out.println(lista.proximo());//devuelve el elemento actual y avanzo
		}
}

public static void imprimirReves (ListaDeEnterosEnlazada lista) {
	//tenes que poner siempre el comenzar adenteo del metdodo
		lista.comenzar();
		imprimirRecursivo (lista);
	}
	
	private static void imprimirRecursivo (ListaDeEnterosEnlazada lista) { //recursivo
	
		if (!lista.fin()) {
			int aux = lista.proximo();
			imprimirRecursivo(lista);
			System.out.println(aux);
		
		}
	}
//--------------------------------------------------------------------------
}