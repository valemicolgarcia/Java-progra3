package grafos.test;

import grafos.Grafo;
import grafos.Arista;
import grafos.Vertice;
import prog3.listagenerica.*;

import grafos.Grafo;


public class GuiaDeTurismo {
	
	/*
	 * caminoConMenorNrodeViajes(Grafo<String> grafo, String puntoInteresOrigen, String
	puntoInteresDestino) : ListaGenerica <String> // Retorna la lista de puntos de interés que
	se deben atravesar en el grafo para ir de puntoInteresOrigen a puntoInteresDestino,
	haciendo la menor cantidad de viajes.
	
	 */
	ListaGenerica <String> caminoMenosViajes (Grafo<String> grafo, String origen, String Destino){
		
		ListaGenerica <String> camino = new ListaGenericaEnlazada <String> () ; // camino que voy a devolver
		
		if (!grafo.esVacio() && (grafo != null)) {
			boolean [] visitados = new boolean [grafo.listaDeVertices().tamanio()];
			ListaGenerica<String> caminoActual = new ListaGenericaEnlazada <>();
			Vertice <String> vIni = null;
			Vertice <String> vFin = null;
			
			//BUSCO LOS VERTICES INICIALES Y FINALES
			ListaGenerica <Vertice<String>> listaDeVertices = grafo.listaDeVertices();
			listaDeVertices.comenzar();
			while (!listaDeVertices.fin()) {
				Vertice <String> vAux = listaDeVertices.proximo();
				if (vAux.dato().equals(origen)) {
					vIni = vAux;
				}
				if (vAux.dato().equals(Destino)) {
					vFin = vAux;
				}
			}
			// LLAMADO A DFS
			dfs (Ini, vFin, )
		
		
		}
		
		return camino;
	}
	
	
	
	
	
	
	
	
}
