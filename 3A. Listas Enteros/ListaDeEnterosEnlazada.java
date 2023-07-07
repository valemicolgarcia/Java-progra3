package prog3.listaenteros;

/**
 * La clase ListaDeEnterosEnlazada es una ListaDeEnteros, donde los elementos de
 * la lista (nodos) referencian al siguiente elemento (nodo), por este motivo,
 * la ListaDeEnterosEnlazada no tiene límite en la cantidad de elementos que se
 * pueden almacenar.
 * */
public class ListaDeEnterosEnlazada extends ListaDeEnteros {
	/* primer nodo de la lista, si la lista esta vacia, inicio es null */
	private NodoEntero inicio;

	/*
	 * nodo actual que se va actualizando a medida que recorremos la lista, si
	 * la lista esta vacia, actual es null
	 */
	private NodoEntero actual;

	/* ultimo nodo de la lista, si la lista esta vacia, fin es null */
	private NodoEntero fin;

	/* cantidad de nodos en la lista */
	private int tamanio;

	@Override
	public void comenzar() {
		actual = inicio;
	}

	@Override
	public Integer proximo() {
		Integer elem = this.actual.getDato();
		this.actual = this.actual.getSiguiente();
		return elem;
	}

	@Override
	public boolean fin() {
		return (this.actual == null);
	}

	@Override
	public Integer elemento(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // no es posicion valida
			return null;
		NodoEntero n = this.inicio;
		while (pos-- > 0)
			n = n.getSiguiente();
		return n.getDato();
	}

	@Override
	public boolean agregarEn(Integer elem, int pos) {
		if (pos < 0 || pos > this.tamanio()) // posicion no valida
			return false;
		this.tamanio++;
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (pos == 0) { // inserta al principio
			aux.setSiguiente(inicio);
			this.inicio = aux;
		} else {
			NodoEntero n = this.inicio;
			NodoEntero ant = null;
			int posActual = 0;
			while (!(n == null) && (posActual < pos)) {
				ant = n;
				n = n.getSiguiente();
				posActual++;
			}
			aux.setSiguiente(n);
			ant.setSiguiente(aux);

			if (aux.getSiguiente() == null)
				this.fin = aux;
		}
		return true;
	}

	@Override
	public boolean agregarInicio(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);

		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			aux.setSiguiente(this.inicio);
			this.inicio = aux;
		}
		this.tamanio++;
		return true;
	}

	@Override
	public boolean agregarFinal(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			fin.setSiguiente(aux);
			fin = aux;
		}
		tamanio++;
		return true;
	}

	@Override
	public boolean eliminar(Integer elem) {
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while ((n != null) && (!n.getDato().equals(elem))) {
			ant = n;
			n = n.getSiguiente();
		}
		if (n == null)
			return false;
		else {
			if (ant == null)
				this.inicio = this.inicio.getSiguiente();
			else
				ant.setSiguiente(n.getSiguiente());
			this.tamanio--;

			return true;
		}
	}

	@Override
	public boolean eliminarEn(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // posicion no valida
			return false;
		this.tamanio--;
		if (pos == 0) {
			this.inicio = this.inicio.getSiguiente();
			return true;
		}
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while (!(n == null) && (pos > 0)) {
			pos--;
			ant = n;
			n = n.getSiguiente();
		}
		ant.setSiguiente(n.getSiguiente());
		if (ant.getSiguiente() == null)
			this.fin = ant;
		return true;
	}

	@Override
	public boolean incluye(Integer elem) {
		NodoEntero n = this.inicio;
		while (!(n == null) && !(n.getDato().equals(elem)))
			n = n.getSiguiente();
		return !(n == null);
	}

	@Override
	public String toString() {
		String str = "";
		NodoEntero n = this.inicio;
		while (n != null) {
			str = str + n.getDato() + " -> ";
			n = n.getSiguiente();
		}
		if (str.length() > 1)
			str = str.substring(0, str.length() - 4);
		return "[" + str + "]";
	}

	@Override
	public int tamanio() {
		return this.tamanio;
	}

	@Override
	public boolean esVacia() {
		return this.tamanio() == 0;
	}
	
	
	
	public ListaDeEnterosEnlazada ordenar() {
	    ListaDeEnterosEnlazada ordenada = new ListaDeEnterosEnlazada();
	    ListaDeEnterosEnlazada copia = new ListaDeEnterosEnlazada();

	    for (int i = 0; i < tamanio(); i++) { //hace la copia lista 1
	        copia.agregarFinal(elemento(i));
	    }

	    while (!copia.esVacia()) {
	        Integer menor = copia.elemento(0); // 
	        int posMenor = 0;

	        for (int i = 1; i < copia.tamanio(); i++) {
	            Integer actual = copia.elemento(i);
	            if (actual < menor) {
	                menor = actual;
	                posMenor = i;
	            }
	        }
	        ordenada.agregarFinal(menor); 
	        copia.eliminarEn(posMenor); //va eliminando
	    }

	    return ordenada;
	}
	//- 6 - 7 lista 2
	//   lista1
	
	// 1    2-4       MERGE
	
	public static int minimo (ListaDeEnterosEnlazada l2, ListaDeEnterosEnlazada l1) {
		int min = 9999;
		if (l1.esVacia() && (l2.esVacia())) { //si las dos listas estan vacias
			min = 9999; 
		}
		else {//------------------------------------------------------------------
			if (( !l1.esVacia() && !l2.esVacia() )) { //si ninguna lista esta vacia
				
				if ( (l1.elemento(0)) <= (l2.elemento(0)) ) {//estoy accediendo a algo que no existe
					min = l1.proximo(); //avanzo en la lista1
					l1.eliminarEn(0); //elimino el primero de la lista 1
				}
				else {
					if ((l2.elemento(0)) < (l1.elemento(0)) ){
						
						min=l2.proximo();
						l2.eliminarEn(0); //elimino el primero de la lista 2
					}
				}
			}//termine el if
			else {
				if ((!l1.esVacia()) && (l2.esVacia())) {
					min= l1.proximo();
					l1.eliminarEn(0);
				}
				else {
					if ((!l2.esVacia()) && (l1.esVacia())) {
						min= l2.proximo();
						l2.eliminarEn(0);
				}
				
				}
			}
	
		}//----------------------
		
		return min;
	}
	
	
	public ListaDeEnterosEnlazada combinarOrdenado(ListaDeEnterosEnlazada listaParam) {
		 
		ListaDeEnterosEnlazada ListaMerge = new ListaDeEnterosEnlazada(); //merge
		
		ListaDeEnterosEnlazada l1 = new ListaDeEnterosEnlazada(); //copia1
		ListaDeEnterosEnlazada l2 = new ListaDeEnterosEnlazada(); //copia2
		
		for (int i = 0; i < (this.tamanio()); i++) { //hace la copia de la lista 1
	        l1.agregarFinal(elemento(i));
	    }
		
		for (int i = 0; i < (listaParam.tamanio()); i++) { //hace la copia de la lista 2
	        l2.agregarFinal(listaParam.elemento(i));
	    }
		
		
		int min = 9999;
					
		min = minimo (l1,l2); 
		
		while (min != 9999) {
			ListaMerge.agregarFinal(min);
			min = minimo(l1,l2);
		}
		
		
		return ListaMerge;
	}

	
	



	
	
}
