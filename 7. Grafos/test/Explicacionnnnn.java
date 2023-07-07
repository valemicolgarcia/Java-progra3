package grafos.test;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.*;
import grafos.*;


public class Explicacionnnnn {
	
	public Resultado resolver(Grafo <String> ciudades, String origen, int montoMax) {
		Resultado  resultado = new Resultado ();
	//	resultado.setMontoSobrante(montoMax);
		//dos alternativas, puedo inicializar la variable d elos costos on el mont maximo
		//entonces cad vez que yo cambio el camino del resultado tambien camnio el conunto
		//para trabajar on grafos necesito (lo diferencia con los arboles) marca de visitados para no entrar en ciclo
		if (ciudades!= null && !ciudades.esVacio()) {
			ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
			boolean [] visitados = new boolean [ciudades.listaDeVertices().tamanio()];
		//la variable montoMax le va cambiando el valor, usa el parametro
			ListaGenerica<Vertice<String>> vertices = ciudades.listaDeVertices();
			vertices.comenzar();
			Vertice<String> vInicial = null;
			while (!vertices.fin() && vInicial == null) {
				Vertice <String> vertice = vertices.proximo();
				if (vertice.dato().equals(origen)) {
					vInicial = vertice;
				}
			}
			if (vInicial != null) { //algunos marcan el visitado aca
				dfs (vInicial, ciudades, visitados, resultado, camino, montoMax);
			}
		}
		return resultado;
	}
	
	private void dfs (Vertice<String>vInicial, Grafo<String>ciudades, boolean []visitados, Resultado resultado, ListaGenerica<String> camino, int montoMax) {
		visitados [vInicial.posicion()]= true;
		camino.agregarFinal(vInicial.dato());
		
		if( (camino.tamanio() > resultado.getCamino().tamanio()) || (camino.tamanio() == resultado.getCamino().tamanio() && resultado.getMontoSobrante() < montoMax)) {
		//	resultado.setCamino(camino.clonar()); //puedo clonar porque tengo el resultado que me lo vava guardar
			//si mando camino, se me va a segir modificando hata eliminarse todo
			//con ptr a otra list qtengo que copiar NO COLNAR
			resultado.setMontoSobrante(montoMax);
					
		}
		
		ListaGenerica<Arista<String>> adyacentes = ciudades.listaDeAdyacentes(vInicial);
		adyacentes.comenzar();
		while (!adyacentes.fin()) {
			Arista<String> arista = adyacentes.proximo();
			int posicion = arista.verticeDestino().posicion();
			if (montoMax - arista.peso() == 0 && !visitados[posicion]) 
				dfs (arista.verticeDestino(), ciudades, visitados, resultado, camino,montoMax - arista.peso());
		}
	
		visitados[vInicial.posicion()] = false;
		camino.eliminarEn (camino.tamanio()-1);
		
	}
}

//el clomar copia lista devuelve los elementos que eta parado y devuelve esa lista con los elementos