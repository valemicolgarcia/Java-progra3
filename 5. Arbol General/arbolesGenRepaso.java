package arbolesGeneral;

import prog3.listagenerica.ListaGenerica;

import prog3.util.*;
import prog3.listagenerica.ListaGenericaEnlazada;



public class arbolesGenRepaso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArbolGeneral <String> nodo8 = new ArbolGeneral <String> ("vale");		
		ArbolGeneral <String> nodo7 = new ArbolGeneral <String> ("hola");		
		ArbolGeneral <String> nodo6 = new ArbolGeneral <String> ("tibu");		
		ListaGenericaEnlazada <ArbolGeneral <String>> l = new ListaGenericaEnlazada <ArbolGeneral <String>> ();
		l.agregarFinal(nodo8);
		l.agregarFinal(nodo6);
		l.agregarFinal(nodo7);
		ArbolGeneral <String> nodo1 = new ArbolGeneral <String> ("chau", l);	
			
		
		ListaGenericaEnlazada <String> l2 = new ListaGenericaEnlazada  <String> ();
		l2 = preOrden(nodo1);
		
		System.out.println(l2.toString());
		int num;
		num = empleadosPorCategoria2 (1, nodo1);
		System.out.println(num);
		
		
	}

	
	
	public static Integer empleadosPorCategoria2 (int categoria, ArbolGeneral <String> a) {
		int cant=0;
		int nivel = 0;
		ColaGenerica <ArbolGeneral<String>> cola = new ColaGenerica <ArbolGeneral<String>>(); 
		ArbolGeneral <String> arbol_aux;
		cola.encolar(a); //encolo la raiz del arbol
		cola.encolar (null); //encola null para saber que termino la raiz
		while (!cola.esVacia()) {
			arbol_aux = cola.desencolar();
			if (arbol_aux != null) {
				if (nivel  ==  categoria ) { //si el dato del arbol es igual a la categoria sumo
					cant++;
				}
				if (arbol_aux.tieneHijos()) {
					ListaGenerica <ArbolGeneral <String>> hijos = arbol_aux.getHijos(); //lista de hijos
					hijos.comenzar();
					while (!hijos.fin()){ //mientras no se termine la lista de hijos
						cola.encolar(hijos.proximo());
					}
				}
				
			}//si el arbol es null, se termino el nivel, entonces encolo null
			
			else {
				if (!cola.esVacia()) {
					cola.encolar(null);
					nivel ++;
				}
					
			}
		}
		return cant;
	}
	
	
	public static ListaGenericaEnlazada<String> preOrden(ArbolGeneral <String> a) {
		ListaGenericaEnlazada<String> lis = new ListaGenericaEnlazada<String>();
		preOrden(a, lis);
		return lis;
	}

	private static void preOrden(ArbolGeneral <String> a, ListaGenericaEnlazada<String> l) {
		l.agregarFinal(a.getDato());
		
		if (a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<String>> hijos = a.getHijos();
			hijos.comenzar();
			
			while(!hijos.fin()) 
				preOrden((hijos.proximo()), l);
		}
	}
}
