package arbolesGeneral;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.util.ColaGenerica;

public class Empresa {
	private ArbolGeneral <Empleado> empleados; //arbol de tipo empleado, aca voy a poner el organigrama
	
	public Empresa (){ //constructor vacio
		
	}
	public Empresa ( ArbolGeneral <Empleado> emple){ //constructor vacio
		this.empleados=emple;
	}
	
	
	//voy recorriendo la categoria que mando como parametro y cuento los nodos.
	public Integer empleadosPorCategoria (int categoria) {
		int cant=0;
		ColaGenerica<ArbolGeneral<Empleado>> cola = new ColaGenerica <ArbolGeneral<Empleado>>(); 
		ArbolGeneral <Empleado> arbol_aux;
		cola.encolar(this.empleados); //encolo la raiz del arbol
		cola.encolar (null); //encola null para saber que termino la raiz
		while (!cola.esVacia()) {
			arbol_aux = cola.desencolar();
			if (arbol_aux != null) {
				if (arbol_aux.getDato().getCategoria() ==  categoria ) { //si el dato del arbol es igual a la categoria sumo
					cant++;
				}
				if (arbol_aux.tieneHijos()) {
					ListaGenerica <ArbolGeneral <Empleado>> hijos = arbol_aux.getHijos(); //lista de hijos
					hijos.comenzar();
					while (!hijos.fin()){ //mientras no se termine la lista de hijos
						cola.encolar(hijos.proximo());
					}
				}
				
			}//si el arbol es null, se termino el nivel, entonces encolo null
			
			else {
				if (!cola.esVacia())
					cola.encolar(null);
			}
		}
		return cant;
	}
	
	public Integer categoriaConMasEmpleados () {
		int cat = 0; //la categoria que voy a devolver
		
		ColaGenerica<ArbolGeneral<Empleado>> cola = new ColaGenerica <ArbolGeneral<Empleado>>(); 
		ArbolGeneral <Empleado> arbol_aux;
		cola.encolar(this.empleados); //encolo la raiz del arbol
		cola.encolar (null); //encola null para saber que termino la raiz
		
		int max = -1; // maxima cant de empleados 
		int cant =0; //cant de empleados
		int catActual = 0; //categoria actual para el corte de control
		while (!cola.esVacia()) {
			arbol_aux = cola.desencolar();
			if (arbol_aux != null) {
				catActual = arbol_aux.getDato().getCategoria(); //categoria actual
				cant++;
				if (arbol_aux.tieneHijos()) {
					ListaGenerica <ArbolGeneral <Empleado>> hijos = arbol_aux.getHijos(); //lista de hijos
					hijos.comenzar();
					while (!hijos.fin()){ //mientras no se termine la lista de hijos
						cola.encolar(hijos.proximo());
					}
				}
				
			}//si el arbol es null, se termino el nivel, entonces encolo null
			else {
				if (!cola.esVacia())
					cola.encolar(null);
					if (cant > max) {
						max = cant;
						cat= catActual;
					}				
					cant = 0; //inicializo cant cada vez que paso de nivel
			}
		}
		return cat;
	}
	
	//cuento todos los empleados incluyendo el presidente --> cuento todos los nodos del arbol.
	public Integer cantidadTotal () {
		int cant=0;
		ColaGenerica<ArbolGeneral<Empleado>> cola = new ColaGenerica <ArbolGeneral<Empleado>>(); 
		ArbolGeneral <Empleado> arbol_aux;
		cola.encolar(this.empleados); //encolo la raiz del arbol
		cola.encolar (null); //encola null para saber que termino la raiz
		while (!cola.esVacia()) {
			arbol_aux = cola.desencolar();
			if (arbol_aux != null) {
				cant++;
				
				if (arbol_aux.tieneHijos()) {
					ListaGenerica <ArbolGeneral <Empleado>> hijos = arbol_aux.getHijos(); //lista de hijos
					hijos.comenzar();
					while (!hijos.fin()){ //mientras no se termine la lista de hijos
						cola.encolar(hijos.proximo());
					}
				}
			}//si el arbol es null, se termino el nivel, entonces encolo null
			
			else {
				if (!cola.esVacia())
					cola.encolar(null);
			}
		}
		return cant;
	}
	
	//no hace bien los reemplazos
	public void reemplazarPresidente () {
		int antiguedad;
		int max = -1;
		Empleado e = new Empleado ();// aca voy a guardar datos para intercambiar con el que esta arriba --> los datos del presidente los piso
		ColaGenerica <ArbolGeneral<Empleado>> cola = new ColaGenerica <ArbolGeneral <Empleado>> (); 
		ArbolGeneral <Empleado> arbol_aux;
		cola.encolar(this.empleados); //encolo la raiz q es el presidente
		cola.encolar(null); //encolo null para indicar que termino el nivel
		while (!cola.esVacia()) {
			arbol_aux = cola.desencolar(); //desencolo la raiz
			if (arbol_aux != null) { //sigo en el mismo nivel
				antiguedad = arbol_aux.getDato().getAntiguedad();
				if (antiguedad > max ) {
					max = antiguedad;
					e = arbol_aux.getDato(); //me guardo los datos del empleado que por ahora es el maximo
				}
				//------------------
				if (arbol_aux.tieneHijos()) { //encolo los hijos del nodo que estoy trabajando
					ListaGenerica <ArbolGeneral <Empleado>> hijos = arbol_aux.getHijos(); //lista de hijos
					hijos.comenzar();
					while (!hijos.fin()){ //mientras no se termine la lista de hijos
						cola.encolar(hijos.proximo());
					}
				}
				//------------------
			}
			else { //esto hay que modificarlo.
				if (!cola.esVacia())
					cola.encolar(null); //cambie de nivel, entonces ahora tengo que reemplazar el nodo presi con el de abajo
				this.empleados.setDato(e); //el valor de la raiz le pomgo los datos de e
	        }
					if (arbol_aux.esHoja())
						arbol_aux.eliminarHijo(arbol_aux);
			}	
		}
	}
	
	