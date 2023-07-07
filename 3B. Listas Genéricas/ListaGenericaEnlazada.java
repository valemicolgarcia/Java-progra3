package prog3.listagenerica;

/**
 * La clase ListaGenericaEnlazada es una ListaGenerica, donde los elementos de
 * la lista (nodos) referencian al siguiente elemento (nodo), por este motivo,
 * la ListaEnlazadaGenerica  no tiene limite en la cantidad de elementos que se
 * pueden almacenar.
 * */
public class ListaGenericaEnlazada<T> extends ListaGenerica<T> {
	/* primer nodo de la lista, si la lista esta vacia, inicio es null */
	private NodoGenerico<T> inicio;

	/*
	 * nodo actual que se va actualizando a medida que recorremos la lista, si
	 * la lista esta vacia, actual es null
	 */
	private NodoGenerico<T> actual;

	/* ultimo nodo de la lista, si la lista esta vacia, fin es null */
	private NodoGenerico<T> fin;

	/* cantidad de nodos en la lista */
	private int tamanio;

	@Override
	public void comenzar() {
		actual = inicio;
	}

	@Override
	public T proximo() {
		T elem = this.actual.getDato();
		this.actual = this.actual.getSiguiente();
		return elem;
	}

	@Override
	public boolean fin() {
		return (this.actual == null);
	}

	@Override
	public T elemento(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // no es posicion valida
			return null;
		NodoGenerico<T> n = this.inicio;
		while (pos-- > 0)
			n = n.getSiguiente();
		return n.getDato();
	}

	@Override
	public boolean agregarEn(T elem, int pos) {
		if (pos < 0 || pos > this.tamanio()) // posicion no valida
			return false;
		this.tamanio++;
		NodoGenerico<T> aux = new NodoGenerico<T>();
		aux.setDato(elem);
		if (pos == 0) { // inserta al principio
			aux.setSiguiente(inicio);
			this.inicio = aux;
		} else {
			NodoGenerico<T> n = this.inicio;
			NodoGenerico<T> ant = null;
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
	public boolean agregarInicio(T elem) {
		NodoGenerico<T> aux = new NodoGenerico<T>();
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
	public boolean agregarFinal(T elem) {
		NodoGenerico<T> aux = new NodoGenerico<T>();
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
	public boolean eliminar(T elem) {
		NodoGenerico<T> n = this.inicio;
		NodoGenerico<T> ant = null;
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
		NodoGenerico<T> n = this.inicio;
		NodoGenerico<T> ant = null;
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
	public boolean incluye(T elem) {
		NodoGenerico<T> n = this.inicio;
		while (!(n == null) && !(n.getDato().equals(elem)))
			n = n.getSiguiente();
		return !(n == null);
	}

	@Override
	public String toString() {
		String str = "";
		NodoGenerico<T> n = this.inicio;
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
	
	public ListaGenericaEnlazada <T> InvertirDatosRecursion (ListaGenericaEnlazada <T>l){
		//this = nueva
		//l = copia que voy a ir disminuyendo
		if (l.tamanio() < 1) {
			return this;   //CASO BASE: si el tama�o de la copia es menor a 1 ya termino
		}
		else {
			
			int i = l.tamanio - 1;
			
			this.agregarFinal(l.elemento(i)); // Agrego en la nueva lista el ultimo elemento
			
			l.eliminarEn(i); //elimino de la copia el ultimo elemento
		
			this.InvertirDatosRecursion(l);
			//en cada llamado se me borra la lista
		}
		
		return l;
	}
	
	
	public ListaGenericaEnlazada<T> invertir(){
	
		
		ListaGenericaEnlazada <T> copia = new ListaGenericaEnlazada <T> (); //copia
		for (int i = 0; i < tamanio(); i++) { //hace la copia lista 1
	        copia.agregarFinal(elemento(i));
	    }
		ListaGenericaEnlazada <T> lista = new ListaGenericaEnlazada <T> (); //invertida
		//La T indica que sirve para cualquier tipo
		
		lista.InvertirDatosRecursion (copia);
		
		return lista;
		
		
	}
	
	
	//-----------------------
}
