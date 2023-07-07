package prog3.listagenerica;



public class ListaGenericatest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListaGenericaEnlazada <Integer> l = new ListaGenericaEnlazada <Integer> ();
		//creo una lista generica
		//cuando la instancio tengo que defnir de que tipo es el objeto que se almacenará
		ListaGenericaEnlazada <Integer> lInv = new ListaGenericaEnlazada <Integer> ();
		
		l.agregarFinal(1);
		l.agregarFinal(2);
		l.agregarFinal(3);
		l.agregarFinal(4);
		l.agregarFinal(5);
		l.agregarFinal(6);
		
		System.out.println("Lista: \n");
		imprimir (l);
		System.out.println("Lista invertida: \n");
		lInv = l.invertir();		
		imprimir (lInv);
		
		

		//------------------------------------------------
	}
	
	
	private static void imprimir (ListaGenericaEnlazada <Integer> lista) {
		
		
		lista.comenzar(); //siempre poner esto, hago que el puntero apunte al inicio
		while (!lista.fin()) { //mientras no llegue al final
			System.out.println(lista.proximo());//devuelve el elemento actual y avanzo
		}
}
	
	
}
