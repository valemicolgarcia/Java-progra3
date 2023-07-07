package grafos.test;

import grafos.Grafo;
import grafos.Arista;
import grafos.Vertice;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.*;


public class Mapa {
	private Grafo <String> mapaCiudades;
	
	public Mapa() { //constructor vacio
	}
	
	public Mapa(Grafo <String >grafo) { // constructor con parametros
		this.mapaCiudades = grafo;
	}
	
	//CAMINO ENTRE DOS CIUDADES--------------------------------------------------------------------------------------------------------
	/*El método devolverCamino (String ciudad1, String ciudad2): ListaGenerica<String>
	// Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso
	que se pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).*/
	
	public ListaGenerica <String> devolverCamino  (String origen, String destino){
		Vertice <String> vInicial = null;
		Vertice<String> vFinal = null;
		boolean [] visitados = new boolean [mapaCiudades.listaDeVertices().tamanio()];        
		ListaGenerica <String> camino = new ListaGenericaEnlazada <String> ();  //camino entre ciudad 1 y ciudad 2
		if ((mapaCiudades != null) && (!mapaCiudades.esVacio())) {     //verificar que el grafo no sea nulo ni vacio
			ListaGenerica <Vertice<String>> vertices = this.mapaCiudades.listaDeVertices(); //lista de todas las ciudades del mapa
			vertices.comenzar();
			while (!vertices.fin()) {                                                  
				Vertice <String> vAux = vertices.proximo();    //me guardo el vertice actual y avanzo en la lista
				if (vAux.dato().equals(origen)) {            
					vInicial = vAux;          //me guardo el vertice que tiene la ciudad 1
				}
				if (vAux.dato().equals(destino)) {
					vFinal = vAux;              //me guardo el vertice que tiene la ciudad 2
				}
			}
			ListaGenerica <String> caminoActual = new ListaGenericaEnlazada <String>(); 
			if (vInicial != null && vFinal != null)    //verifico si existen la ciudad 1 y 2
				dfsCamino ( vInicial, vFinal, caminoActual, camino, visitados); //disparo el dfs
			
		}
		return camino; //devuelvo el camino encontrado, que puede llegar a ser una lista vacia
	}
	//---------------
	private void dfsCamino (Vertice<String> vIni, Vertice<String> vFin,ListaGenerica <String> caminoActual, ListaGenerica<String> camino, boolean []visitados) {
		caminoActual.agregarFinal(vIni.dato());                                           
		visitados [vIni.posicion()]=true;                                                  
		if (vIni == vFin) { 
			copiarLista (caminoActual, camino); //si llego al vertice final, copio el contenido de la lista actual a camino
		} else {
			ListaGenerica <Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vIni);  //me guardo la lista de adyacentes al vertice actual
			ady.comenzar();
			while (!ady.fin()) {
				Vertice<String> vAux = ady.proximo().verticeDestino(); 
				if (!visitados[vAux.posicion()]) {  //si todavia no fue visitado se dispara el dfs
					dfsCamino (vAux, vFin, caminoActual, camino, visitados);  //vAux se transforma en el vertice inicial
				}
			}
		}
		//caminoActual.eliminarEn(caminoActual.tamanio()-1);   //elimino el ultimo vertice agregado al camino actual
		//visitados [vIni.posicion()] = false;     //lo marco como no visitado
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
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//CAMINO EXCEPTUANDO UNA LISTA
	/*
			 * El método devolverCaminoExceptuando (String ciudad1, String ciudad2,
		ListaGenerica<String> ciudades): ListaGenerica<String> // Retorna la lista de ciudades
		que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades que están
		contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
		vacía. (Sin tener en cuenta el combustible).
	 */
	
	public ListaGenerica <String> devolverCaminoExceptuando (String origen, String destino,ListaGenerica<String> ciudades){
		Vertice <String> vInicial = null;
		Vertice<String> vFinal = null;
		
		boolean [] visitados = new boolean [mapaCiudades.listaDeVertices().tamanio()];        
		ListaGenerica <String> camino = new ListaGenericaEnlazada <String> ();                
		
		if ((mapaCiudades != null) && (!mapaCiudades.esVacio())) {                             //verificar que el grafo no sea nulo ni vacio
			ListaGenerica <Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();   //lista de todas las ciudades del mapa
			vertices.comenzar();
			while (!vertices.fin()) {                                                  
				Vertice <String> vAux = vertices.proximo();    //me guardo el vertice actual y avanzo en la lista
				if (vAux.dato().equals(origen)) {            
					vInicial = vAux;               //me guardo el vertice que tiene la ciudad 1
				}
				if (vAux.dato().equals(destino)) {
					vFinal = vAux;                   //me guardo el vertice que tiene la ciudad 2
				}
			}
			ListaGenerica <String> caminoActual = new ListaGenericaEnlazada <String>(); 
			if (vInicial != null && vFinal != null)                                          //verifico si existen la ciudad 1 y 2
				dfsExceptuando (vInicial, vFinal, caminoActual, camino, visitados, ciudades); //disparo el dfs
			
		}
		return camino; //devuelvo el camino encontrado, que puede llegar a ser una lista vacia
	}
	
	//---------------
		private void dfsExceptuando (Vertice<String> vIni, Vertice<String> vFin,ListaGenerica <String> caminoActual, ListaGenerica<String> camino, boolean []visitados,ListaGenerica<String> ciudades) {
			if (!ciudades.incluye(vIni.dato())){ //!!!!!!!!!!!!
				System.out.println("imprimo el que se agregaaaaaaaaaaaaaa");
				System.out.println(vIni.dato());
				caminoActual.agregarFinal(vIni.dato());       //agrego el vertice actual al camino actual, solo si la lista ciudades no lo incluye
			}
			visitados [vIni.posicion()]=true;                 //marco el vertice como visitado
			if (vIni == vFin) { 
				copiarLista (caminoActual, camino);     //si llego al vertice final, copio el contenido de la lista actual a camino
			} else {
				ListaGenerica <Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vIni);     //me guardo la lista de adyacentes al vertice actual
				ady.comenzar();
				while (!ady.fin()) {
					Vertice<String> vAux = ady.proximo().verticeDestino(); 
					if (!visitados[vAux.posicion()]) {        //si todavia no fue visitado se dispara el dfs
						dfsExceptuando (vAux, vFin, caminoActual, camino, visitados, ciudades);  //vAux se transforma en el vertice inicial
					}
				}
			}
		
			//estos no los necesito porque despues de que encontre el camino no quiero seguir recorriendo.
		//	caminoActual.eliminarEn(caminoActual.tamanio()-1);     //elimino el ultimo vertice agregado al camino actual
		//visitados [vIni.posicion()] = false;         //lo marco como no visitado
		}
		
		
		//el copiar lista es el mismo que en el inciso anterior.
		
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------
	 //CAMINO MAS CORTO
			 * El método caminoMasCorto(String ciudad1, String ciudad2): ListaGenerica<String> //
		Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a
		ciudad2, si no existe camino retorna la lista vacía. (Las rutas poseen la distancia). (Sin tener
		en cuenta el combustible).

	 */
	
		public ListaGenerica <String> caminoMasCorto  (String origen, String destino){
			Vertice <String> vInicial = null;
			Vertice<String> vFinal = null;
			boolean [] visitados = new boolean [mapaCiudades.listaDeVertices().tamanio()];         //arreglo de visitados
			ListaGenerica <String> camino = new ListaGenericaEnlazada <String> ();                 //camino entre ciudad 1 y ciudad 2
			if ((mapaCiudades != null) && (!mapaCiudades.esVacio())) {                             //verificar que el grafo no sea nulo ni vacio
				ListaGenerica <Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();   //lista de todas las ciudades del mapa
				vertices.comenzar();
				while (!vertices.fin()) {                                                  
					Vertice <String> vAux = vertices.proximo();                                   //me guardo el vertice actual y avanzo en la lista
					if (vAux.dato().equals(origen)) {            
						vInicial = vAux;                                                          //me guardo el vertice que tiene la ciudad 1
					}
					if (vAux.dato().equals(destino)) {
						vFinal = vAux;                                                           //me guardo el vertice que tiene la ciudad 2
					}
				}
				ListaGenerica <String> caminoActual = new ListaGenericaEnlazada <String>(); 
				if (vInicial != null && vFinal != null)                                          //verifico si existen la ciudad 1 y 2
					dfsCorto ( vInicial, vFinal, caminoActual, camino, visitados);              //disparo el dfs
				
			}
			return camino; //devuelvo el camino encontrado, que puede llegar a ser una lista vacia
		}
		//---------------
		private void dfsCorto (Vertice<String> vIni, Vertice<String> vFin,ListaGenerica <String> caminoActual, ListaGenerica<String> camino, boolean []visitados) {
			caminoActual.agregarFinal(vIni.dato());                                             //agrego el vertice actual al camino actual
			visitados [vIni.posicion()]=true;                                                   //marco el vertice como visitado
			if (vIni == vFin) { 
				if (camino.esVacia() || camino.tamanio() > caminoActual.tamanio() )
					copiarLista (caminoActual, camino);                                         //si llego al vertice final, copio el contenido de la lista actual a camino
			} else {
				ListaGenerica <Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vIni);     //me guardo la lista de adyacentes al vertice actual
				ady.comenzar();
				while (!ady.fin()) {
					Vertice<String> vAux = ady.proximo().verticeDestino(); 
					if (!visitados[vAux.posicion()]) {                                         //si todavia no fue visitado se dispara el dfs
						dfsCamino (vAux, vFin, caminoActual, camino, visitados);              //vAux se transforma en el vertice inicial
					}
				}
			}
			caminoActual.eliminarEn(caminoActual.tamanio()-1);                                //elimino el ultimo vertice agregado al camino actual
			visitados [vIni.posicion()] = false;                                              //lo marco como no visitado
		}
		
		//el copiar lista es el mismo que el de antes
	
		/*----------------------------------------------------------------------------------------------------------------------------------------------------
		 * METODO CAMINO SIN CARGAR COMBUSTIBLE
			El método caminoSinCargarCombustible(String ciudad1, String ciudad2, int
			tanqueAuto): ListaGenerica<String> // Retorna la lista de ciudades que forman un camino
			para llegar de ciudad1 a ciudad2. El auto no debe quedarse sin combustible y no puede
			cargar. Si no existe camino retorna la lista vacía.
		 */
		
		public ListaGenerica <String> caminoSinCargarCombustible  (String origen, String destino, int tanqueAuto){
			Vertice <String> vInicial = null;
			Vertice<String> vFinal = null;
		//	int combActual = 0;
			int combustible = tanqueAuto;
			boolean [] visitados = new boolean [mapaCiudades.listaDeVertices().tamanio()];         //arreglo de visitados
			ListaGenerica <String> camino = new ListaGenericaEnlazada <String> ();                 //camino entre ciudad 1 y ciudad 2
			if ((mapaCiudades != null) && (!mapaCiudades.esVacio())) {                             //verificar que el grafo no sea nulo ni vacio
				ListaGenerica <Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();   //lista de todas las ciudades del mapa
				vertices.comenzar();
				while (!vertices.fin()) {                                                  
					Vertice <String> vAux = vertices.proximo();                                   //me guardo el vertice actual y avanzo en la lista
					if (vAux.dato().equals(origen)) {            
						vInicial = vAux;                                                          //me guardo el vertice que tiene la ciudad 1
					}
					if (vAux.dato().equals(destino)) {
						vFinal = vAux;                                                           //me guardo el vertice que tiene la ciudad 2
					}
				}
				ListaGenerica <String> caminoActual = new ListaGenericaEnlazada <String>(); 
				if (vInicial != null && vFinal != null)                                          //verifico si existen la ciudad 1 y 2
					dfsSinCombustible ( vInicial, vFinal, caminoActual, camino, visitados, combustible);              //disparo el dfs
				
			}
			return camino; //devuelvo el camino encontrado, que puede llegar a ser una lista vacia
	
		}
		//---------------
		private void dfsSinCombustible(Vertice<String> vIni, Vertice<String> vFin,ListaGenerica <String> caminoActual, ListaGenerica<String> camino, boolean []visitados, int combustible) {
		//	if ((combustible > 0)) {
				caminoActual.agregarFinal(vIni.dato());                                             //agrego el vertice actual al camino actual
				System.out.println(vIni.dato());
				System.out.println(combustible);
				System.out.println("ddattttttttttttttttttttt");
		//	}
			visitados [vIni.posicion()]=true;                                                   //marco el vertice como visitado
			if  ((vIni == vFin)&&(combustible>0)) { 
				System.out.println("terminoooooooooooooooooooo");
				if (camino.esVacia() || camino.tamanio() > caminoActual.tamanio() )
					copiarLista (caminoActual, camino);                                         //si llego al vertice final, copio el contenido de la lista actual a camino
			} else {
				ListaGenerica <Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vIni);     //me guardo la lista de adyacentes al vertice actual
				
				ady.comenzar();
				while (!ady.fin()) {
					Arista<String> arista = ady.proximo();
					Vertice<String> vAux = arista.verticeDestino();  
							
					if (!visitados[vAux.posicion()]) {                                                    //si todavia no fue visitado se dispara el dfs
						combustible -= arista.peso();                      //!!! le resto la nafta
						dfsSinCombustible (vAux, vFin, caminoActual, camino, visitados,combustible);  
						combustible += arista.peso();
					}
				}
			}
			//if (combustible < 0) {
				
				caminoActual.eliminarEn(caminoActual.tamanio()-1);                                //elimino el ultimo vertice agregado al camino actual
				visitados [vIni.posicion()] = false;                                              //lo marco como no visitado
				//no se si esta bien esto
		//	}
			//combustible += combActual;  //lo hice para cuando vuelve de la recursion
		}
				
		/*--------------------------------------------------------------------------------------------------------------------------------------------
		 METODO CAMINO CON MENOR CARGA DE COMBUSTIBLE
		 El método caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int
		tanqueAuto): ListaGenerica<String> // Retorna la lista de ciudades que forman un camino
		para llegar de ciudad1 a ciudad2 teniendo en cuenta que el auto debe cargar la menor
		cantidad de veces. El auto no se debe quedar sin combustible en medio de una ruta, además
		puede completar su tanque al llegar a cualquier ciudad. Si no existe camino retorna la lista
		vacía.
		 */
		
		//el camino con menor carga de combustible va a ser el que pase por menos vertices
		
		public ListaGenerica <String> caminoConMenorCargaDeCombustible  (String origen, String destino, int tanqueAuto){
			Vertice <String> vInicial = null;
			Vertice<String> vFinal = null;
		
			int combustible = tanqueAuto;
		
			boolean [] visitados = new boolean [mapaCiudades.listaDeVertices().tamanio()];         //arreglo de visitados
			ListaGenerica <String> camino = new ListaGenericaEnlazada <String> ();                 //camino entre ciudad 1 y ciudad 2
			if ((mapaCiudades != null) && (!mapaCiudades.esVacio())) {                             //verificar que el grafo no sea nulo ni vacio
				ListaGenerica <Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();   //lista de todas las ciudades del mapa
				vertices.comenzar();
				while (!vertices.fin()) {                                                  
					Vertice <String> vAux = vertices.proximo();    //me guardo el vertice actual y avanzo en la lista
					if (vAux.dato().equals(origen)) {            
						vInicial = vAux;                           //me guardo el vertice que tiene la ciudad 1
					}
					if (vAux.dato().equals(destino)) {
						vFinal = vAux;                            //me guardo el vertice que tiene la ciudad 2
					}
				}
				ListaGenerica <String> caminoActual = new ListaGenericaEnlazada <String>(); 
				if (vInicial != null && vFinal != null)                                          //verifico si existen la ciudad 1 y 2
					dfsCargaComb ( vInicial, vFinal, caminoActual, camino, visitados, tanqueAuto, combustible, 0, 0);              //disparo el dfs
				
			}
			return camino; //devuelvo el camino encontrado, que puede llegar a ser una lista vacia
	
		}
		//---------------
		private void dfsCargaComb(Vertice<String> vIni, Vertice<String> vFin,ListaGenerica <String> caminoActual, ListaGenerica<String> camino, boolean []visitados, int tanque, int combustible, int carga, int cargaActual) {
	
				//System.out.println("IMPRIMO TANQUE ABAJO");
				//System.out.println(tanque);
				caminoActual.agregarFinal(vIni.dato());                                             //agrego el vertice actual al camino actual
			//	System.out.println("ddattttttttttttttttttttt");
			//	System.out.println(vIni.dato());
			//	System.out.println("COmbustible que 	queda");
			//	System.out.println(combustible);
	
			visitados [vIni.posicion()]=true;                                                   //marco el vertice como visitado
			if  ((vIni == vFin)&&(combustible>0)) { 
				if (camino.esVacia() || carga > cargaActual ) {
					copiarLista (caminoActual, camino);                                         //si llego al vertice final, copio el contenido de la lista actual a camino
					carga = cargaActual;
				}
			} else {
				ListaGenerica <Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vIni);     //me guardo la lista de adyacentes al vertice actual
				
				ady.comenzar();
				while (!ady.fin()) {
					Arista<String> arista = ady.proximo();
					Vertice<String> vAux = arista.verticeDestino();  
							
					if (!visitados[vAux.posicion()]) {          //si todavia no fue visitado se dispara el dfs
						
						if (combustible - arista.peso()  < 0) {
							cargaActual++; //incremento la carga
							combustible = tanque; //lleno el tanque
						}
						
						combustible -= arista.peso(); 
						
						//!!! le resto la nafta
						dfsCargaComb (vAux, vFin, caminoActual, camino, visitados,tanque, combustible, carga, cargaActual);  
						combustible += arista.peso();
					}
				}
			}
		
				caminoActual.eliminarEn(caminoActual.tamanio()-1);                                //elimino el ultimo vertice agregado al camino actual
				visitados [vIni.posicion()] = false;                                              //lo marco como no visitado
	
		}
		
		
		//------------no tocar este-->  } es para cerrar la clase
		}
