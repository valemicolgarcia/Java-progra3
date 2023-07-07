package grafos.test;
import grafos.Grafo;
import grafos.Arista;
import grafos.Vertice;
import prog3.listagenerica.*;

import grafos.Grafo;

public class Delta {
	
	public Delta() { //constructor vacio de la clase
		
	}
	
	/*  MAX ISLAS DISTINTAS------------------------------------------------------------------------------------------
		maxIslasDistintas(Grafo<String> grafo) : int // Retorna el número máximo de islas distintas
		que se pueden recorrer en el grafo comprando un único boleto.
	 */
	
	public int maxIslasDistintas (Grafo <String> grafo) {
		int numMax = 0;
		if (!grafo.esVacio()) {
			boolean [] visitados = new boolean [grafo.listaDeVertices().tamanio()]; //el primer vertice es el principla
			Vertice<String> muellePrincipal = grafo.listaDeVertices().elemento(0); //lista de todos los vertices del grafo
			visitados [0] = true;
			//LISTA DE ARISTAS DEL VERTICE DE SALIDA
			ListaGenerica <Arista<String>> listaRamas = grafo.listaDeAdyacentes(muellePrincipal); //lista de ramas
			while (!listaRamas.fin()) {
				int num=1;
				num += dfs (listaRamas.proximo().verticeDestino(), visitados, grafo);
				System.out.println("volviiiii, y numero es" + num);
				if (num>numMax)
					numMax = num;
			}	
		}
		return numMax;
	}
	
	private int dfs (Vertice<String> vIni, boolean []visitados, Grafo <String> grafo) {
		int num = 1;
		System.out.println("imprimo numero de verticessssssssssssssss: " + num);          
		visitados [vIni.posicion()] = true; //marco como visitado el vertice que proceso
		
		ListaGenerica <Arista<String>> ady = grafo.listaDeAdyacentes(vIni);  //me guardo la lista de adyacentes al vertice actual
		ady.comenzar();
		while (!ady.fin()) {
			Vertice<String> vAux = ady.proximo().verticeDestino(); 
			if (!visitados[vAux.posicion()]) {      //si todavia no fue visitado se dispara el dfs
				num += dfs (vAux, visitados, grafo);  //vAux se transforma en el vertice inicial
			} 
		}
		return num;
	}
	//----------------------------------------------------------------------------------------------
	
	/*  CAMINO MAS CORTO
		caminoMasCorto(Grafo<String> grafo, String islaO, String islaD) : RutaMinima //
		Retorna un objeto de la clase RutaMinima, el cual contiene el camino más corto entre islaO
		e islaD y si se puede realizar con un único boleto o es necesario comprar un nuevo boleto
		para completar el recorrido.
	 */
	
	public RutaMinima caminoMasCorto (Grafo<String> grafo, String islaO, String islaD) {
		RutaMinima ruta = new RutaMinima();
		int boletos = 1; //como minimo va a haber un boleto
		
		//dos vertices
		Vertice <String> vInicial = null;
		Vertice<String> vFinal = null;
		
		//arreglo de visitados
		boolean [] visitados = new boolean [grafo.listaDeVertices().tamanio()];
		
		//lista que va a tener camino que quiero setear.
		ListaGenerica <String> camino = new ListaGenericaEnlazada <String> (); 
		//
		if ((grafo != null) && (!grafo.esVacio())) {
			
			//Buso vertices iniciales y finales
			ListaGenerica <Vertice<String>> vertices = grafo.listaDeVertices(); 
			vertices.comenzar();
			while (!vertices.fin()) {
				Vertice <String> vAux = vertices.proximo();
				if (vAux.dato().equals(islaO)) {
					vInicial = vAux;            }
				if (vAux.dato().equals(islaD)) {
					vFinal = vAux;            }
			}
			ListaGenerica <String> caminoActual = new ListaGenericaEnlazada <String>(); 
			if (vInicial != null && vFinal != null)  
				dfsCorto ( vInicial, vFinal, caminoActual, camino, visitados, grafo, boletos);	
		}
		
		ruta.setBoletos(boletos);
		ruta.setCamino(camino);
		
		return ruta;
	}
	
	
	
	
	private void dfsCorto (Vertice<String> vIni, Vertice<String> vFin,ListaGenerica <String> caminoActual, ListaGenerica<String> camino, boolean []visitados, Grafo<String>grafo, int boletos) {
		
		//agrego al final el vertice que estoy procesando y lo marco como visitado
		caminoActual.agregarFinal(vIni.dato());      
		visitados [vIni.posicion()]=true;    
		
		//si paso por el muelle principal, quiere decir que estoy buscando en otro camino
		if (vIni.posicion() == 0) { 
			boletos ++;
		}
		
		//llegue al final del camino?
		if (vIni == vFin) { 
			if (camino.esVacia() || camino.tamanio() > caminoActual.tamanio() )
				copiarLista (caminoActual, camino);     
			
		} else { //si no llegue al final del camino
			
			//recorro los adyacentes del vertice que se procesa
			ListaGenerica <Arista<String>> ady = grafo.listaDeAdyacentes(vIni);     
			ady.comenzar();
			while (!ady.fin()) {
				Vertice<String> vAux = ady.proximo().verticeDestino(); 
				if (!visitados[vAux.posicion()]) {                              
					dfsCorto (vAux, vFin, caminoActual, camino, visitados,grafo, boletos);         
				}
			}
		}
		caminoActual.eliminarEn(caminoActual.tamanio()-1);                               
		visitados [vIni.posicion()] = false;    
	}
	
	//-------------------
		private void copiarLista (ListaGenerica<String> caminoActual, ListaGenerica<String> camino) { // a este metodo entra cuando ya encontro la ciudad 2.
			while (!camino.esVacia())     //elimino lo que tiene la lista camino
				camino.eliminarEn(0);
			caminoActual.comenzar();
			while (!caminoActual.fin()) {
				camino.agregarFinal(caminoActual.proximo());    //copio lo de la lista actual en la lista caminos
			}
		}	
	
	//--------------------------------------------------------
	
	
//ESTE ES DEL FIN DE CLASE	
}
	
	
	
	

