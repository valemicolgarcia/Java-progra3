package grafos.test;

import grafos.Grafo;
import grafos.Arista;
import grafos.Vertice;
import prog3.listagenerica.*;

public class Algoritmos <T> {
	
	/*subgrafoCuadrado(Grafo<T> grafo): boolean // Retorna true si un dígrafo contiene un
	subgrafo cuadrado, false en caso contrario. Un subgrafo cuadrado es un ciclo simple de
	longitud 4.
	 * */
	
	//CAMINO SIMPLE: todos sus vertices, excepto el primero y el ultimo son diferentes
	//CICLO SIMPLE: vuelve a donde arranco, con camino simple
	//CICLO DE LONGITUD CUATRO : 4 ARISTAS (lineas) 
	
	//no se como hacer para que me vuelva a procesar el vertice inicial, y asi demostrar que es un ciclo.
	
	public boolean subgrafoCuadrado (Grafo<T>grafo) { //vini y v final tienen que ser iguales
		int cantAristas = 1;
		Vertice <T> vActual = null;
		boolean resultado = false;
		if (!grafo.esVacio()) {
			boolean [] visitados = new boolean [grafo.listaDeVertices().tamanio()];  //arreglo para saber los vertices que ya fueron visitados
			ListaGenerica <Vertice<T>> listaDeVertices = grafo.listaDeVertices(); //agarro la lista de vertices y empiezo a recorrerla
			listaDeVertices.comenzar();
			while (!listaDeVertices.fin()) {
				Vertice<T> vInicial = listaDeVertices.proximo(); //avanzo 
				boolean [] marcas = new boolean [grafo.listaDeVertices().tamanio()]; //visitados dentro de la recursion. (para cd vertice)
				if (!visitados [vInicial.posicion()]) {
					vActual = vInicial;
					System.out.println("cambia de vertice----------------------");
					resultado = dfs (vInicial, vActual,  visitados, marcas, grafo, cantAristas);   }   }   }
		System.out.println("el restltado essssssssssssssss");
		System.out.println(resultado);
		return resultado;
	}
	 
	private boolean dfs (Vertice<T> vInicial,Vertice<T> vActual, boolean []visitados,boolean [] marcas, Grafo<T> grafo, int cantAristas) {
		visitados [vInicial.posicion()]= true; //solamente marco el inicial como visitado
		marcas [vActual.posicion()]= true; //marco el actual como visitado en el arreglo que manejo adentro de la recursion.
		System.out.println("cantidad de aristas: " + cantAristas);
		//aca tenia el analisis sssssss
		//cantAristas++;
		if (vInicial == vActual) { //hay ciclo
			System.out.println("vert inciial igual aa ctuaaaaaaaaaal");
			System.out.println("cuando son iguales, las arisyas son" + cantAristas);
			if (cantAristas == 4) {
				System.out.println("entroooooooooooooooooooooooooo"); //no entra nunca no se porq ue
				return true;
				//hay 4 aristas
			}
		}
		boolean resul = false;
		//cada vertice tiene sus adyacentes, que son los que voy a recorrer para saber si es ciclo o no.
		ListaGenerica <Arista<T>> listaDeAdyacentes = grafo.listaDeAdyacentes(vActual);
		listaDeAdyacentes.comenzar();
		while (!listaDeAdyacentes.fin()) {
			Vertice <T> vAux = listaDeAdyacentes.proximo().verticeDestino(); //vertice siguiente al actual
			if (marcas[vAux.posicion()]) {
				if (cantAristas == 4) {
					return true;
				}
			} else {	
				resul = dfs (vInicial, vAux, visitados, marcas, grafo, cantAristas+1); //vAux va a ser vActual 
				if (resul == true)
					break;
			}
		}
		
		marcas[vActual.posicion()] = false; // desmarcar el vértice actual antes de salir de la recursión
	    return false;
		
	}
	
	/* GET GRADO --> recorrido bfs
		 * getGrado(Grafo<T> grafo) : int // Retorna el grado del digrafo pasado como parámetro. El
	grado de un digrafo es el de su vértice de grado máximo. El grado de un vértice en un grafo
	dirigido es la suma del número de aristas que salen de él (grado de salida) y el número de
	aristas que entran en él (grado de entrada).
	 */
	
	//para grafos no dirigidos, hay que hacerlo para grafos dirigidos?
	
	 public int getGrado(Grafo<T> grafo) {
	        int grado = 0;
	        ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
	        vertices.comenzar();
	        while (!vertices.fin()) {
	            Vertice<T> v = vertices.proximo();
	            ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(v);
	            if (adyacentes.tamanio() > grado) {
	                grado = adyacentes.tamanio();
	            }
	        }
	        return grado;
	    }
	 
	 /* TIENE CICLO-------------------------------------------------------------------
			  * tieneCiclo(Grafo<T> grafo): boolean // Retorna true si el grafo dirigido pasado como
		parámetro tiene al menos un ciclo, false en caso contrario.
	  */ //Estoy en el mismo caso que el uno, no se como hacer para que me recorra dos veces el mismo vertice.
	 
	 
	 
	
	
	
	
	
	
	
//----- este es para el fin de clase	
}
