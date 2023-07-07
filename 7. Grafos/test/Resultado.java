package grafos.test;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.*;
import grafos.*;

public class Resultado {

	private ListaGenerica <String> camino;
	private int montoSobrante;
	
	public Resultado () {
		camino = new ListaGenericaEnlazada <String>();
		montoSobrante = 0;
	}
	
	
	
	public ListaGenerica<String> getCamino() {
		return camino;
	}
	public void setCamino(ListaGenerica<String> camino) {
		this.camino = camino;
	}
	public int getMontoSobrante() {
		return montoSobrante;
	}
	public void setMontoSobrante(int montoSobrante) {
		this.montoSobrante = montoSobrante;
	}
	
	
	
}
