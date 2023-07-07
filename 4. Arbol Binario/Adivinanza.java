package arboles.arbol;

import prog3.listaenteros.ListaDeEnterosEnlazada;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Adivinanza {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//CREACION DEL ARBOL:
				ArbolBinario<String> arbolBinarioA; //declaro arbol binario A
				arbolBinarioA= new ArbolBinario<String>("¿Tiene cuatro patas?"); //pongo la raiz en 7	
				//creo el hijo izquierdo
				ArbolBinario<String> hijoIzquierdo=new ArbolBinario<String>("¿Se mueve?"); //hijo izq de la raiz
				hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<String>("¿Ladra?")); //hijo izq de "SE MUEVE"
				
				ArbolBinario <String> nodoLadra = hijoIzquierdo.getHijoIzquierdo(); //asigno el ladra a un nodo accesible
				nodoLadra.agregarHijoIzquierdo(new ArbolBinario <String> ("ES UN PERRO")); //le creo un hijo izquierdo en la misma linea que lo agrego
				nodoLadra.agregarHijoDerecho(new ArbolBinario <String> ("ES UN GATOO")); 
			
				hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<String>("ES UNA MESA"));
				//creo el hijo derecho
				ArbolBinario<String> hijoDerecho=new ArbolBinario<String>("¿Tiene alguna pata?");
				hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<String>("HOOOOLAAAA"));
				hijoDerecho.agregarHijoDerecho(new ArbolBinario<String>("CHAU"));
				//los agrego a la raiz
				arbolBinarioA.agregarHijoIzquierdo(hijoIzquierdo);
				arbolBinarioA.agregarHijoDerecho(hijoDerecho);
		
			System.out.println("El camino  mas largo en el arbol es: " + (secuenciaConMasPreguntas (arbolBinarioA)).toString());
			
			
			
			
			
			
			
		//	ListaGenericaEnlazada <ListaGenericaEnlazada <String>> caminos; //creo un vector y le asigno el que devuelvo del metdo
			//	caminos = secuenciaConMasPreguntasVersion2 (arbolBinarioA);
			//	System.out.println(caminos.toString());
				
				
			//	System.out.println("CAMINO [0]: " + caminos[0].toString());
				//System.out.println("CAMINO [1]: " + caminos[1].toString());
			//	System.out.println("hola");
				
			/*	if (caminos[0].tamanio() > caminos [1].tamanio())
					System.out.println("CAMINO + LARGO:" + caminos [0].toString());
				else {
					if (caminos [1].tamanio()> caminos [0].tamanio())
						System.out.println("CAMINO + LARGO:" + caminos [1].toString());
					else {
						if (caminos [0].tamanio() == caminos [1].tamanio()) {
							System.out.println("PRIMER camino largo: " + caminos [0].toString());
							System.out.println("SEGUNDO camino largo: " + caminos [1].toString());
						}	
					}
				}*/
					
			//no me guarda CAMINO + LARGO:¿Tiene cuatro patas? -> ¿Se mueve? -> ¿Ladra? -> ES UN GATOO
				//hay algunos nodos que no se agregan no encuentro el error
	
		
	}
	public static ListaGenericaEnlazada <ListaGenericaEnlazada <String>>  secuenciaConMasPreguntasVersion2 (ArbolBinario <String> arbol){
		
		ListaGenericaEnlazada <ListaGenericaEnlazada <String>> l3= new ListaGenericaEnlazada <ListaGenericaEnlazada <String>>();
		ListaGenericaEnlazada <ListaGenericaEnlazada <String>> l= new ListaGenericaEnlazada <ListaGenericaEnlazada <String>>();
		ListaGenericaEnlazada <ListaGenericaEnlazada <String>> l2= new ListaGenericaEnlazada <ListaGenericaEnlazada <String>>();
		//--------------------------
		ListaGenericaEnlazada <String> izq = new ListaGenericaEnlazada ();
		ListaGenericaEnlazada <String> der = new ListaGenericaEnlazada ();
		
		l.agregarFinal(izq);
		l2.agregarFinal(der);

		if (arbol == null) {// si el arbol esta vacio
			return l3; //se retorna el vector vacio
		}else 
			if (arbol.esHoja()) {
				l.elemento(0).agregarFinal(arbol.getDato());
				return l;
				}
			else {
			 l = secuenciaConMasPreguntasVersion2 (arbol.getHijoIzquierdo()); //izquierda
			 l2 = secuenciaConMasPreguntasVersion2 (arbol.getHijoDerecho()); //derecha
			
			 /* l.comenzar();
			 ListaGenericaEnlazada <String> aux = new ListaGenericaEnlazada ();
			 int max = -1;
			 while (!l.fin()) {
				if( aux.tamanio() > max)
					
			 }*/
				 
			 if (l.elemento(0).tamanio() > l2.elemento(0).tamanio()){ 
				 l.elemento(0).agregarInicio(arbol.getDato()); //agrego dato a la lista izq
				 
				 return (l);
			 }
			 else if (l2.elemento(0).tamanio() > l2.elemento(0).tamanio()) {
				 l2.elemento(0).agregarInicio(arbol.getDato()); //agrego dato a la lista derecha
				 return (l2);
			 } else {
					 //si las dos listas son iguales hay que retornar cualquiera de ellos
					 //entonces agrgo a las dos listas
					 l.elemento(0).agregarInicio(arbol.getDato());
					 l2.elemento(0).agregarInicio(arbol.getDato());
					 //FUSIONAR LISTAS
					 l.comenzar();
					 while (!l.fin()) {
						 l3.agregarFinal(l.proximo());
					 }
					 while (!l2.fin()) {
						 l3.agregarFinal(l2.proximo());
					 }
					 
				 
				
				 
				 return l3; //es lo mismo cual retorno porque son iguales
			 }
		}
	}


	
	//------------------------------------------------------------
	public static ListaGenericaEnlazada <String> secuenciaConMasPreguntas (ArbolBinario <String> arbol){
		
		ListaGenericaEnlazada <String> l = new ListaGenericaEnlazada <String> ();
		ListaGenericaEnlazada <String> izq = new ListaGenericaEnlazada <String> ();
		ListaGenericaEnlazada <String> der = new ListaGenericaEnlazada <String> ();

		if (arbol == null) {// si el arbol esta vacio
			return l; //se retorna la lista vacia
		}
		else {
			 izq = secuenciaConMasPreguntas (arbol.getHijoIzquierdo()); //izquierda
			 der = secuenciaConMasPreguntas (arbol.getHijoDerecho()); //derecha
			
			 if (izq.tamanio() > der.tamanio()){ 
				 izq.agregarInicio(arbol.getDato()); //agrego dato a la lista izq
				 return (izq);
			 }
			 else if (der.tamanio() < izq.tamanio()) {
				 der.agregarInicio(arbol.getDato()); //agrego dato a la lista derecha
				 return (der);
			 } else {
				 //si las dos listas son iguales hay que retornar cualquiera de ellos
				 //entonces agrgo a las dos listas
				 izq.agregarInicio(arbol.getDato());
				 der.agregarInicio(arbol.getDato());
				 return der; //es lo mismo cual retorno porque son iguales
			 }
		}
	}
}
