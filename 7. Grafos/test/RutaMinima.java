package grafos.test;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class RutaMinima {
	private ListaGenerica <String> camino = new ListaGenericaEnlazada <String> ();    
	private int boletos = 0;
	
	//------------------------------------------------------------------------
	public RutaMinima() { //constructor vacio
		
	}
	public RutaMinima(ListaGenerica <String> camino, int boletos) { //constructor con parametros
		this.camino = camino;
		this.boletos = boletos;
	}
	
	//GETTERS Y SETTERS ------------------------------------------------------
	public ListaGenerica<String> getCamino() {
		return camino;
	}
	public void setCamino(ListaGenerica<String> camino) {
		this.camino = camino;
	}
	public int getBoletos() {
		return boletos;
	}
	public void setBoletos(int boletos) {
		this.boletos = boletos;
	}
	//--------------------------------------------------------------------------
	
	
	
}
