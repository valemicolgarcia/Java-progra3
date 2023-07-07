package prog3.listaenteros;

public class TestOrdenamientos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada ();
		ListaDeEnterosEnlazada l2 = new ListaDeEnterosEnlazada ();
		
		
		l.agregarFinal(8);
		l.agregarFinal(6);
		l.agregarFinal(4);
		l.agregarFinal(1);
		l.agregarFinal(3);
		System.out.println("Imprime la lista antes de ordenarla");
		imprimir (l); 
		
		System.out.println("Imprime la lista 1 ordenada");
		imprimir (l.ordenar());
		
		System.out.println("------------------------");
		l2.agregarFinal(5);
		l2.agregarFinal(9);
		l2.agregarFinal(10);
		l2.agregarFinal(15);
		System.out.println("Imprime la lista 2 antes de ordenarla");
		imprimir (l2); 
		
		System.out.println("Imprime la lista 2 ordenada");
		imprimir (l2.ordenar());
		
		
		System.out.println("Imprime merge de listas");
		imprimir ((l.ordenar()).combinarOrdenado(l2.ordenar()));
		
		
		System.out.println("HOLAAAAAAAAAAAAAAAAAA");
		System.out.println("holachau");

	}
	
	
	
//------------------------------------------------------------
private static void imprimir (ListaDeEnterosEnlazada lista) {
		
		// RECORRIDO DE UNA LISTA //usar este!!!!!!!!!
		lista.comenzar(); //siempre poner esto, hago que el puntero apunte al inicio
		while (!lista.fin()) { //mientras no llegue al final
			System.out.println(lista.proximo());//devuelve el elemento actual y avanzo
		}
}

//------------------------


	
//-----------------------------------------
}
