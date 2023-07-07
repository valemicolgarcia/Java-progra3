package arboles.arbol;
import prog3.listaenteros.ListaDeEnterosEnlazada;
import prog3.listagenerica.*;

public class Adivinanza2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArbolBinario<String> arbolBinarioA; //declaro arbol binario A
		arbolBinarioA= new ArbolBinario<String>("¿Tiene cuatro patas?"); //pongo la raiz en 7	
		//creo el hijo izquierdo
		ArbolBinario<String> hijoIzquierdo=new ArbolBinario<String>("¿Se mueve?"); //hijo izq de la raiz
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<String>("¿Ladra?")); //hijo izq de "SE MUEVE"
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<String>("ES UNA MESA"));

		ArbolBinario <String> nodoLadra = hijoIzquierdo.getHijoIzquierdo(); //asigno el ladra a un nodo accesible
		nodoLadra.agregarHijoIzquierdo(new ArbolBinario <String> ("ES UN PERRO")); //le creo un hijo izquierdo en la misma linea que lo agrego
		nodoLadra.agregarHijoDerecho(new ArbolBinario <String> ("ES UN GATOO")); 
		//creo el hijo derecho
		ArbolBinario<String> hijoDerecho=new ArbolBinario<String>("¿Tiene alguna pata?");
		hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<String>("HOOOOLAAAA"));
		hijoDerecho.agregarHijoDerecho(new ArbolBinario<String>("CHAU"));
		//los agrego a la raiz
		arbolBinarioA.agregarHijoIzquierdo(hijoIzquierdo);
		arbolBinarioA.agregarHijoDerecho(hijoDerecho);
		//--------------------------------------------------------------------
		
		System.out.println("El camino  mas largo en el arbol es: " + (secuenciaConMasPreguntas (arbolBinarioA)).toString());
		System.out.println("holachauhola");
	//	System.out.println("El camino  mas largo en el arbol es: " + (secuenciaConMasPreguntasss (arbolBinarioA)).toString());

		//System.out.println("El camino  mas largo en el arbol es: " + (secuenciaConMasPreguntasVersion2 (arbolBinarioA)).toString());

	}

	public static ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciaConMasPreguntasVersion2(ArbolBinario<String> abinario) {
		// CREO LISTAS DE LISTAS, RESULTADO (PARA RETORNAR) Y AUXILIAR (PARA ANALIZAR SITUACION DEL NODO ACTUAL)
		ListaGenericaEnlazada<ListaGenericaEnlazada<String>> result = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
		ListaGenericaEnlazada<ListaGenericaEnlazada<String>> izq = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
		ListaGenericaEnlazada<ListaGenericaEnlazada<String>> der = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
		
		if (abinario.esHoja()) {
			// BASE CASE ///////////////
			ListaGenericaEnlazada<String> nueva = new ListaGenericaEnlazada<String>();
			nueva.agregarInicio(abinario.getDato());
			result.agregarInicio(nueva);
			
		} else {
			// PROCESO HIJO IZQUIERDO ///////////
			if (abinario.tieneHijoIzquierdo()) {
				izq = secuenciaConMasPreguntasVersion2(abinario.getHijoIzquierdo()); // RECURSION RECUPERADA EN VARIABLE aux
				
				// SI EL RESULTADO ES NULO O EL CAMINO ACTUAL ES MAYOR QUE LOS ALMACENADOS EN RESULTADO ENTONCES 
				// VACIO LA LISTA RESULTADO Y AGREGO EL CAMINO ACTUAL COMO NUEVA SOLUCION DE MAYOR TAMANIO
				if ((result.elemento(0) == null) || (izq.elemento(0).tamanio() > result.elemento(0).tamanio())) {
					while (!result.esVacia()) result.eliminarEn(0);
					izq.comenzar();
					while (!izq.fin()) result.agregarInicio(izq.proximo());
				} else if (izq.elemento(0).tamanio() == result.elemento(0).tamanio()) {
					izq.comenzar();
					while (!izq.fin()) result.agregarInicio(izq.proximo());
				}
			}
			
			// PROCESO HIJO DERECHO ////////////
			if (abinario.tieneHijoDerecho()) {
				der = secuenciaConMasPreguntasVersion2(abinario.getHijoDerecho());
				
				if ((result.elemento(0) == null) || (der.elemento(0).tamanio() > result.elemento(0).tamanio())) {
					while (!result.esVacia()) result.eliminarEn(0);
					der.comenzar();
					while (!der.fin()) result.agregarInicio(der.proximo());
				} else if (der.elemento(0).tamanio() == result.elemento(0).tamanio()) {
					der.comenzar();
					while (!der.fin()) result.agregarInicio(der.proximo());
				}
			}
			
			// AGREGO DATO A TODAS LAS LISTAS RESULTADOS ////////////////
			result.comenzar();
			while (!result.fin()) result.proximo().agregarInicio(abinario.getDato());
		}
		
		return result;
		
	}
	
	public static ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> abinario) {
		ListaGenericaEnlazada<String> result = new ListaGenericaEnlazada<String>();
		ListaGenericaEnlazada<String> izq= new ListaGenericaEnlazada<String>();
		ListaGenericaEnlazada<String> der = new ListaGenericaEnlazada<String>();
		
		
		if (abinario.tieneHijoIzquierdo()) {
			izq = secuenciaConMasPreguntas(abinario.getHijoIzquierdo());
		}
		
		if (abinario.tieneHijoDerecho()) {
			der = secuenciaConMasPreguntas(abinario.getHijoDerecho());
		}
		
		if (izq.tamanio() > der.tamanio())
			result = izq;
		else if (der.tamanio() >= izq.tamanio())
			result = der;
			
		
		result.agregarInicio(abinario.getDato());
		
		
		return result;
	
	}
	
	
	
	
}
