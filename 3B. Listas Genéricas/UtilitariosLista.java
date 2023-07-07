package prog3.util;

import prog3.listaenteros.ListaDeEnterosEnlazada;

public class UtilitariosLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada ();
		
		
		l.agregarFinal(8);
		l.agregarFinal(6);
		l.agregarFinal(4);
		l.agregarFinal(1);

		System.out.println("Imprime la lista antes de ordenarla");
		imprimir (l); 
		
		ListaDeEnterosEnlazada listaNueva = new ListaDeEnterosEnlazada ();
		
		
		listaNueva = MergeSort (l); //no se como llamar a merge sort
		
		//listaNueva = l.MergeSort(); // le asigno a la nueva lista la que ordeno con merge sort
		System.out.println("MERGEEEEEEEE");
		
		imprimir(listaNueva);
		
		
		
		
	}

	
	
private static void imprimir (ListaDeEnterosEnlazada lista) {
		
		// RECORRIDO DE UNA LISTA //usar este!!!!!!!!!
		lista.comenzar(); //siempre poner esto, hago que el puntero apunte al inicio
		while (!lista.fin()) { //mientras no llegue al final
			System.out.println(lista.proximo());//devuelve el elemento actual y avanzo
		}
}
	

public static ListaDeEnterosEnlazada obtenerLista1 (ListaDeEnterosEnlazada lista) {
	
	ListaDeEnterosEnlazada listaMitad = new ListaDeEnterosEnlazada ();
	
	for (int i = 0; i < (lista.tamanio())/2 ; i++) { 
        listaMitad.agregarFinal(lista.elemento(i));
    }
	
	
	return listaMitad;
}


public static ListaDeEnterosEnlazada obtenerLista2 (ListaDeEnterosEnlazada lista) {
	
	ListaDeEnterosEnlazada listaMitad = new ListaDeEnterosEnlazada ();
	
	for (int i = (lista.tamanio())/2; i < lista.tamanio() ; i++) { 
        listaMitad.agregarFinal(lista.elemento(i)); 
        
    }
	
	return listaMitad;
}


public static ListaDeEnterosEnlazada MergeSort (ListaDeEnterosEnlazada l) {
	
	ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada (); //lista
	
	
	
	if ((l.tamanio()) <= 1) { //l es la que mando
		return l;
	} else {
		ListaDeEnterosEnlazada izq = new ListaDeEnterosEnlazada ();
		ListaDeEnterosEnlazada der = new ListaDeEnterosEnlazada ();
		
		izq = obtenerLista1 (l);
		der = obtenerLista2 (l);
		
		izq= MergeSort(izq);
		der= MergeSort(der);
		
		lista = der.combinarOrdenado(izq);
		
		
	}
	
	
	return lista;
}
	
	
	
}
