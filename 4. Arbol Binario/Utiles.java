package arboles.arbol;

import prog3.listaenteros.ListaDeEnterosEnlazada;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.util.*;

public class Utiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//CREACION DEL ARBOL:
		ArbolBinario<Integer> arbolBinarioA; //declaro arbol binario A
		arbolBinarioA=new ArbolBinario<Integer>(7); //pongo la raiz en 7	
		//creo el hijo izquierdo
		ArbolBinario<Integer> hijoIzquierdo=new ArbolBinario<Integer>(1);
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
		//creo el hijo derecho
		ArbolBinario<Integer> hijoDerecho=new ArbolBinario<Integer>(3);
		hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		hijoDerecho.agregarHijoDerecho(new ArbolBinario<Integer>(1));
		//los agrego a la raiz
		arbolBinarioA.agregarHijoIzquierdo(hijoIzquierdo);
		arbolBinarioA.agregarHijoDerecho(hijoDerecho);
		
		
	// LLAMO A SUMA MAXIMA VERTICAL:
	System.out.println("La suma maxima vertical esss: " + sumaMaximaVertical2 (arbolBinarioA));
	//LLAMO A SUMA MAXIMA HORIZONTAL
	//System.out.println("La suma maxima horizontal es: " + sumaMaximaHorizontal (arbolBinarioA));
	//LLAMO A TRAYECTORIA PESADA
	System.out.println("La trayectoria pesada es " + (trayectoriaPesada2 (arbolBinarioA)).toString());
	System.out.println("hola");
	System.out.println("La trayectoria pesada es " + (trayectoriaPesada3 (arbolBinarioA)).toString());
	}


	private static void trayectoriaPesadaRecursivo3 (ArbolBinario<Integer> ab, ListaGenericaEnlazada<Integer> result, int nivel, int accumulador) {
		
		
		accumulador += (nivel * ab.getDato());
		nivel++;
		
		
		if (ab.esHoja()) {
			result.agregarFinal(accumulador);	
			accumulador = 0;
		} else {
			if (ab.tieneHijoIzquierdo()) {
				trayectoriaPesadaRecursivo3(ab.getHijoIzquierdo(), result, nivel, accumulador);
			}
			
			if (ab.tieneHijoDerecho()) {
				trayectoriaPesadaRecursivo3(ab.getHijoDerecho(), result, nivel, accumulador);
			}
		}

		
				
		
	}
	
	
private static ListaGenericaEnlazada<Integer> trayectoriaPesada3(ArbolBinario<Integer> ab) {
		
		ListaGenericaEnlazada<Integer> result = new ListaGenericaEnlazada<Integer>();
	//	int nivel = 0;
		trayectoriaPesadaRecursivo3(ab, result, 0, 0); //nivel era -1
		
		return result;
	}
//---------------------------------------------------------------------------------
	private static ListaGenericaEnlazada<Integer> trayectoriaPesadaRecursivo2(ArbolBinario<Integer> ab, ListaGenericaEnlazada<Integer> result, int nivel, int accumulador) {
		nivel++;
		accumulador += (nivel * ab.getDato());
		
		if (ab.esHoja()) {
			result.agregarFinal(accumulador);		
		} else {
			if (ab.tieneHijoIzquierdo()) {
				result = trayectoriaPesadaRecursivo2(ab.getHijoIzquierdo(), result, nivel, accumulador);
			}
			
			if (ab.tieneHijoDerecho()) {
				result = trayectoriaPesadaRecursivo2(ab.getHijoDerecho(), result, nivel, accumulador);
			}
		}
		
		return result;
		
	}
	
	
private static ListaGenericaEnlazada<Integer> trayectoriaPesada2(ArbolBinario<Integer> ab) {
		
		ListaGenericaEnlazada<Integer> result = new ListaGenericaEnlazada<Integer>();
	//	int nivel = 0;
		trayectoriaPesadaRecursivo2(ab, result, -1, 0); //nivel era -1
		
		return result;
	}
	
	//-----------------------------------------------------------------------------
	
	// de joaquin
	private static int sumaMaximaVertical2 (ArbolBinario<Integer> arbol) {
		int result = arbol.getDato();
		int aux1 = 0;
		int aux2 = 0;
		
		if (arbol.tieneHijoIzquierdo()) {
			aux1 = sumaMaximaVertical2(arbol.getHijoIzquierdo());
		}
		
		if (arbol.tieneHijoDerecho()) {
			aux2 = sumaMaximaVertical2(arbol.getHijoDerecho());
		}
		
		if (aux1 > aux2) {
		    result += aux1;
		} else {
		    result += aux2;
		}
		//result += (aux1 > aux2) ? aux1 : aux2; 
		
		return result;
	}
	
	
//--------------TRAYECTORIA PESADA------------------------------------
private static ListaGenericaEnlazada <Integer> trayectoriaPesada (ArbolBinario <Integer> arbol) {
	ListaGenericaEnlazada <Integer> l = new ListaGenericaEnlazada <Integer> (); //declaro variable y la inicializo
	int suma = 0;
	int nivel = 0;
	trayectoriaPesadaRecursivo (arbol, l, suma, nivel);	
	return l;
		}
	
private static void  trayectoriaPesadaRecursivo (ArbolBinario <Integer> arbol, ListaGenericaEnlazada <Integer> l, int suma, int nivel) {
	

	//necesito recorrer hasta que encuentre una hoja (nodo que no tiene ningun hijo)
	if (arbol == null) {
		return; //que vuelva
	}
	else {
		if (arbol.esHoja()) {
			suma+= (arbol.getDato() * nivel); //sumo el ultimo elemento * nivel
			
			l.agregarFinal(suma); //agrego el valor de la suma de los nodos a la lista
			
		}
		else {
			//es un hijo
			suma += (arbol.getDato() * nivel); //sumo el dato con el nivel en el que estoy
			nivel ++; //cada vez que sumo un elemento estoy en un nivel mas ya que sumo verticalemnete
			trayectoriaPesadaRecursivo (arbol.getHijoIzquierdo(), l, suma, nivel);
			trayectoriaPesadaRecursivo (arbol.getHijoDerecho(), l, suma, nivel);
			
		}
	}
	
	
}



	
//---------------HORIZONTAL---------------------------------------------------
	
private static int sumaMaximaHorizontal (ArbolBinario <Integer> arbol) {
	int sumaMax = 0; 
	int suma = 0;
	
	ArbolBinario <Integer> a = null; //creo un arbol
	ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica <ArbolBinario<Integer>>(); //cola
	cola.encolar(arbol);//encolo la raiz
	cola.encolar(null); //ahi termina el primer nivel -null marca eso
	
	while (!cola.esVacia()) {//mientras la cola no este vacia
		a = cola.desencolar(); //lleno el arbol con elemento de la cola
		if (a != null) {
			suma += a.getDato(); //sumo el elemento
			if (a.tieneHijoIzquierdo())
				cola.encolar(a.getHijoIzquierdo()); //encolo hijo izq
			if (a.tieneHijoDerecho())
				cola.encolar(a.getHijoDerecho()); //encolo hijo der
		} else if (!cola.esVacia()) {
			if (suma > sumaMax) {
				sumaMax =suma;
			}
			cola.encolar(null); //indica que se termino el nivel
			
			suma = 0; //inicializo la suma en 0 para el proximo nivel.
		}
	}
	//si no entro al while, tengo que verificar por afuera
	/*if (suma > sumaMax) {
		sumaMax = suma;
	}*/
	return sumaMax;
}



//-------------------VERTICAL---------------------------------------------------
private static int sumaMaximaVertical (ArbolBinario <Integer> arbol) {
		
return sumaMaximaVerticalRecursivo (arbol);
}

private static int sumaMaximaVerticalRecursivo(ArbolBinario<Integer> arbol) {
    if (arbol == null) {
      return 0;
    } else {
      int suma_izquierda = sumaMaximaVerticalRecursivo(arbol.getHijoIzquierdo());
      int suma_derecha = sumaMaximaVerticalRecursivo(arbol.getHijoDerecho());
      if (suma_derecha > suma_izquierda) {
        return suma_derecha + arbol.getDato();
      } else {
        return suma_izquierda + arbol.getDato();
      }
    }
  }
}

