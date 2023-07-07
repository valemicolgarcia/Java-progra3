package arbolesGeneral;

import prog3.listagenerica.ListaGenerica;

import prog3.util.*;
import prog3.listagenerica.ListaGenericaEnlazada;

public class ArbolGeneral<T> {

	private T dato; 
	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaGenericaEnlazada<T> preOrden() {
		return null;
	}
	
	
	//IMPLEMENTADO
	public Integer altura() {
		if (!this.esVacio()) {
			if (this.esHoja())
				return 0;
			else {
				ListaGenerica <ArbolGeneral<T>> hijos = this.getHijos();
				ArbolGeneral <T> unHijo = null;
				int maximo = 0;
				int altCalc = 0;
				hijos.comenzar();
				while (!hijos.fin()) {
					unHijo = hijos.proximo();
					altCalc = unHijo.altura();
					if (maximo < altCalc)
						maximo = altCalc;
				}
				return 1 + maximo;
			}
		}
		
		return 0;
	}
	
	//devuelve el nivel donde se encontro el dato en el arbol
	public Integer nivel (T dato) {
		int niv = -1; //inicializo en -1 el nivel
		if (dato.equals(this.getDato())) //si el dato buscado es igual al del arbol retorno 0
			return 0;
		if (this.tieneHijos()) {
			for (int i=0; i<hijos.tamanio();i++) {
				niv = this.getHijos().elemento(i).nivel(dato);
				if (niv != -1)
					return niv + 1; //tengo que sumarle uno porque esta inicializado en 0
			}	
		}
		return niv;
	}
	
	

	
	//devuelve la amlitud de un arbol, es decir la cantidad de nodos
	//que se encuentra en el nivel que posee la mayor cantidad de nodos
	public Integer ancho() {
		
		ColaGenerica <ArbolGeneral<T>> cola = new ColaGenerica <ArbolGeneral<T>> ();
		ArbolGeneral <T> arbol;
		cola.encolar(this);
		cola.encolar(null);

		int amplitud = 0;
		int cantidad = 0;
		
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				for (int i=0; i< arbol.getHijos().tamanio(); i++) {
					cola.encolar(arbol.getHijos().elemento(i));
					cantidad ++;
				}
			}
			else if (!cola.esVacia()) {
				if (cantidad > amplitud)
					amplitud = cantidad;
				cola.encolar(null);
				cantidad = 0; 
			}
		}
		return amplitud;
	}
	
	public ListaGenericaEnlazada <T> porNiveles(){ //terminar de completar el recorrido por niveles
		ListaGenericaEnlazada<T> result = new ListaGenericaEnlazada<T>();
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica <ArbolGeneral<T>>();
		
		ArbolGeneral <T> arbol_aux;
		cola.encolar(this);
		
		while (!cola.esVacia()) {
			arbol_aux = cola.desencolar();
			result.agregarFinal(arbol_aux.getDato());
			if (arbol_aux.tieneHijos()) {
				ListaGenerica <ArbolGeneral <T>> hijos = arbol_aux.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			}
		}
		return result;
	}
	
	
	public boolean include (T dato) {
		boolean esta = false; //inicializo variable en false
		if (dato.equals(this.getDato())) //comparo el dato del arbol con dato para ver si son iguales
			return true;
		if (this.tieneHijos()) { //si el nodo tiene hijos se realiza un for a traves de los hijos del nodo actual
			for (int i = 0; i<hijos.tamanio(); i++) {
				esta = this.getHijos().elemento(i).include(dato); //se llama RECURSIVAMENTE a include para buscar dato en cada hijo
				if (esta) //si se encuentra en alguno de los hijos, esta = true
					return esta; //devuelvo true
			}
		}
		
		return esta; //si despues de revisar todo el dato no se ha encontrado devuelve false
	}

}