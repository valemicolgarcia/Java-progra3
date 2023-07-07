package arbolesGeneral;

import prog3.listagenerica.ListaGenerica;

public class Trie extends ArbolGeneral<Character>{

	public Trie(Character dato) { //constructor que permite crear hojas
		super(dato);
	}
	
	public Trie(Character dato, ListaGenerica<ArbolGeneral<Character>> hijos) { //constructor que permite crear nodos con listas
		super(dato, hijos);
	}
	
	public void agregarPalabra(String palabra) { //le mando una palabra
		
		 int len = palabra.length();  //longitud de la palabra
	        ArbolGeneral<Character> arbol =  new ArbolGeneral<Character>(null);
	        
	        for (int i = 0; i<len; i++) { //por cada caracter de la palabra
	            ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos(); //lista de los hijos
	            char c = palabra.charAt(i);
	            if (!hijos.esVacia()) {
	                hijos.comenzar();
	                int j = 0;
	                for (j = 0; j<hijos.tamanio(); j++) {
	                    if (hijos.elemento(j).getDato() >= c) {
	                        break;
	                    }
	                }
	                if ((j != hijos.tamanio()) && (hijos.elemento(j).getDato() ==c)) {
	                    arbol = hijos.elemento(j);
	                } else {
	                    ArbolGeneral<Character> aux = new ArbolGeneral<Character>(c);
	                    hijos.agregarEn(aux, j);
	                    arbol = aux;
	                }
	            }
	            else {
	                ArbolGeneral<Character> aux = new ArbolGeneral<Character>(c);
	                hijos.agregarInicio(aux);
	                arbol = aux;
	            }
	        }
		
	}

	@Override
	public String toString() {
		return super.getDato() + " " + super.getHijos() + " ";
	}
	
}

