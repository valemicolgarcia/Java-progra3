package prog3.util;


import prog3.listagenerica.ListaGenericaEnlazada;

public class Pila<T>  {
	
	ListaGenericaEnlazada <T> pila;
	
	//tenia mal este constructor!!
	public Pila() {
		ListaGenericaEnlazada <T> lista = new ListaGenericaEnlazada <T>();
		this.pila = lista;
	}
	
	public void apilar (T elem) {
		
		this.pila.agregarInicio(elem); //apila por eso arriba se agrega
		
	}
//-----------------------------------------------
	public T desapilar () {
		T aux = this.pila.elemento(0); //primer elemento
		this.pila.eliminarEn(0); //elimino el que esta mas arriba
		return aux;
	}
//----------------------------------------------
	public T tope () {
		return this.pila.elemento (0);
	}
//----------------------------------------------
	public boolean esVacia() {
		return this.pila.esVacia();
	}
	

}
