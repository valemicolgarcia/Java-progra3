package arboles.arbol;

import prog3.listagenerica.*;
import prog3.util.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	
	public boolean esLleno() {
        ArbolBinario<T> arbol = null; 
        ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>(); //se utiliza para almacenar los nodos del arbol
        boolean lleno = true; //inicializa variable
        cola.encolar( this); //se agrega la raiz a la cola
        int cant_nodos=0;
        cola.encolar( null);
        int nivel= 0;
        while (!cola.esVacia() && lleno) {
            arbol = cola.desencolar();
            if (arbol != null) {
                System.out.print(arbol.getDato()); //get raiz
                if (!arbol.tieneHijoIzquierdo()) {
                    cola.encolar(arbol.getHijoIzquierdo());
                    cant_nodos++;
                } 
                if (!(arbol.tieneHijoDerecho())) { //lo cambiamos
                    cola.encolar(arbol.getHijoDerecho());
                    cant_nodos++;
                }
            } else if (!cola.esVacia()) {
                if (cant_nodos == Math.pow(2, ++nivel)){
                    cola.encolar( null);
                    cant_nodos=0;
                    System. out.println();
                }
                else lleno=false;}
        }
        return lleno;
       }
	
	

	 boolean esCompleto() {
		 
		 /* ARBOL COMPLETO: Un árboL binario de altura h es completo si es lleno 
		  * hasta el nivel (h-1) y el nivel h se completa de izquierda a derecha. 
		  * 
		  * se podria agregar un parametro h para indicar el nivel hasta 
		  * el cual se debe verificar para ver si esta completo.
		  * dentro del bucle while se podria verificar si el nivel actual es menor que h,
		  * y se iria verificando si el arbol esta lleno
		  * si el nivel actual es igual a h se debe verificar que los nodos del nivel h
		  * se llenen de izquierda a derceha. Para hacer esto, se recorre el nivel h hasta que
		  * se encuentra un null, si hya mas nodos despues del null, quiere decir que
		  * no se completo de izquierda a derecha, entonces se establece completo en false
		  * 
		  * */
		 
		return false;
	}

	
	// imprime el arbol en preorden  
	public void printPreorden(ArbolBinario<T> arbol) {
		
		System.out.println(arbol.getDato());
		if (arbol.tieneHijoIzquierdo()) {
			this.printPreorden(arbol.getHijoIzquierdo());
		}
		if (arbol.tieneHijoDerecho()) {
			this.printPreorden(arbol.getHijoDerecho());
		}
	}

	// imprime el arbol en postorden
	public void printInorden(ArbolBinario<T> arbol) {
		
		if (arbol.tieneHijoIzquierdo()) {
			this.printInorden(arbol.getHijoIzquierdo());
		}
		System.out.println(arbol.getDato());
		if (arbol.tieneHijoDerecho()) {
			this.printInorden(arbol.getHijoDerecho());
		}	
	}
	
	// imprime el arbol en postorden
	public void printPostorden(ArbolBinario<T> arbol) {
		
		if (arbol.tieneHijoIzquierdo()) {
			this.printPostorden(arbol.getHijoIzquierdo());
		}
		if (arbol.tieneHijoDerecho()) {
			this.printPostorden(arbol.getHijoDerecho());
		}
		System.out.println(arbol.getDato());
	}

	public void recorridoPorNiveles() {
		
	}

	
	//-----------------------------------------
	private  void fronteraRecursivo (ListaGenerica<T> listaFrontera) {
		if (this.tieneHijoIzquierdo())
		    this.getHijoIzquierdo().fronteraRecursivo(listaFrontera);
		if (this.esHoja())
		    listaFrontera.agregarFinal(this.getDato()); //caso base
		if (this.tieneHijoDerecho())
			this.getHijoDerecho().fronteraRecursivo(listaFrontera);
		}
		public ListaGenerica<T> frontera() {
		    ListaGenerica<T> listaFrontera= new ListaGenericaEnlazada <T> (); 
		    //le agregamos enlazada
		    this.fronteraRecursivo(listaFrontera);
		    return listaFrontera;
		    //devuelve una lista de elementos con los nodos hoja
		}
	//-------------------------------------------
	/*public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaGenericaEnlazada<T>();

		return l;
	}
*/
	//---------------------------------------	
		public int contarHojas() {
	        int hojas = 0;
	        if (this.esHoja())
	            return 1; // tmb puede ser hojas=1
	        else {
	            if (this.tieneHijoIzquierdo())
	                hojas = this.getHijoIzquierdo().contarHojas();

	            if (this.tieneHijoDerecho())
	                hojas = this.getHijoDerecho().contarHojas(); 
	        }
	        return hojas;
	    }	
	//---------------------------------------	
/*	public int contarHojas() {
		return 0;}
	*/

}
