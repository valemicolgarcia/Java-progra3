package grafos.test;

//import grafos.Grafo;
//import grafos.Arista;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.*;
import grafos.*;


public class TestMapa {
    public static void main(String[] args){
    	
    	// CREACION DEL GRAFO CIUDADES!!
    	//Creacion de vertices
        Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
		Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
		Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
		Vertice<String> v4 = new VerticeImplListAdy<String>("Montevideo");
		Vertice<String> v5 = new VerticeImplListAdy<String>("Asuncion");
		Vertice<String> v6 = new VerticeImplListAdy<String>("Caracas");
		Vertice<String> v7 = new VerticeImplListAdy<String>("La Habana");
		//instancio el grafo
		Grafo<String> ciudades = new GrafoImplListAdy<String>();
		//agrego los vertices
		ciudades.agregarVertice(v1);
		ciudades.agregarVertice(v2);
		ciudades.agregarVertice(v3);
		ciudades.agregarVertice(v4);
		ciudades.agregarVertice(v5);
		ciudades.agregarVertice(v6);
		ciudades.agregarVertice(v7);
		//conecto los vertices
		ciudades.conectar(v1, v2,3);
		ciudades.conectar(v1, v3,2);
		ciudades.conectar(v1, v4,4);
		ciudades.conectar(v1, v5,10);
		ciudades.conectar(v2, v5,500);
		ciudades.conectar(v2, v7,4);
		ciudades.conectar(v3, v5,4);//modifico este para ver que funciona, tenia un 4
		ciudades.conectar(v4, v5,6);
		ciudades.conectar(v6, v5,11);
		ciudades.conectar(v6, v7,10);
		
		//CREACION DE MAPA!!
        Mapa m = new Mapa (ciudades);       
        
       //devolver camino entre ciudad 1 y ciudad 2.------------------------------
      //funciona bien :)
        
      /*
        ListaGenerica<String> lis = m.devolverCamino("Buenos Aires","Asuncion");
		System.out.println("--- Se imprime devolverCamino ---");
		if (lis.elemento(0) != null) { //no estoy segura de ese lis.elemento(0)
			System.out.println("Se encontro un camino");
			lis.comenzar();
			while(!lis.fin()) {
				System.out.println(lis.proximo());
			}
		}else {
			
			System.out.println("No hay camino entre esas ciudades.");
		}
		
        
		//devolver camino exceptuando una lista de ciudades----------------------
		// funciona bien :)
	/*	ListaGenerica<String> exceptuando = new ListaGenericaEnlazada<String>();
		exceptuando.agregarFinal("Santiago");
		exceptuando.agregarFinal("Lima");
		exceptuando.agregarFinal("Montevideo");
		ListaGenerica<String> lis2 = m.devolverCaminoExceptuando("Buenos Aires","Asuncion",exceptuando);
		System.out.println("--- Se imprime devolverCaminoExceptuando ---");
		lis2.comenzar();
		while(!lis2.fin()) {
			System.out.println(lis2.proximo());
		}
		*/
		
		/*
	 	//devolver camino mas corto entre dos ciudades ----------------------
		// funciona bien :)
		ListaGenerica<String> lis3 = m.caminoMasCorto("Buenos Aires","Asuncion");
		System.out.println("--- Se imprime caminoMasCorto ---");
		lis3.comenzar();
		while(!lis3.fin()) {
			System.out.println(lis3.proximo());
		}
		*/
		
	/*
        
      //devolver camino sin cargar combustible----------------------
      // funciona bien :)
		ListaGenerica<String> lis4 = m.caminoSinCargarCombustible("Buenos Aires","Asuncion",7);
		System.out.println("--- Se imprime caminoSinCargarCombustible ---");
		lis4.comenzar();
		while(!lis4.fin()) {
			System.out.println(lis4.proximo());
		}
		
		*/
        
       //devolver camino sin cargar combustible----------------------
       // funciona bien :)
        //PARA VERIFICAR QUE FUNCIONE --> cambio la conexion entre v3 y v5, con nro chico o grande, son caminos diferentes.
		ListaGenerica<String> lis5 = m.caminoConMenorCargaDeCombustible("Buenos Aires","Asuncion",8);
		System.out.println("--- Se imprime caminoConMenorCargaDeCombustible ---");
		lis5.comenzar();
		while(!lis5.fin()) {
			System.out.println(lis5.proximo());
		}
		

    }
}