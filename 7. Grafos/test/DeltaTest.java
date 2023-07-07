package grafos.test;

//import grafos.Grafo;
//import grafos.Arista;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.*;
import grafos.*;



public class DeltaTest {
	  public static void main(String args[]) {
	    Vertice<String> v1 = new VerticeImplListAdy<String>("Maldivas");
	    Vertice<String> v2 = new VerticeImplListAdy<String>("Hawai");
	    Vertice<String> v3 = new VerticeImplListAdy<String>("Bali");
	    Vertice<String> v4 = new VerticeImplListAdy<String>("Creta");
	    Vertice<String> v5 = new VerticeImplListAdy<String>("Ibiza");
	    Vertice<String> v6 = new VerticeImplListAdy<String>("Sicilia");
	    Vertice<String> v7 = new VerticeImplListAdy<String>("Galapagos");
	    Vertice<String> v8 = new VerticeImplListAdy<String>("Tasmania");
	    Vertice<String> v9 = new VerticeImplListAdy<String>("Islas Vírgenes Britanicas");
	    Vertice<String> v10 = new VerticeImplListAdy<String>("Jamaica");

	    Grafo<String> islas = new GrafoImplListAdy<String>();
	    islas.agregarVertice(v1);
	    islas.agregarVertice(v2);
	    islas.agregarVertice(v3);
	    islas.agregarVertice(v4);
	    islas.agregarVertice(v5);
	    islas.agregarVertice(v6);
	    islas.agregarVertice(v7);
	    islas.agregarVertice(v8);
	    islas.agregarVertice(v9);
	    islas.agregarVertice(v10);

	    islas.conectar(v1, v2, 3);
	    islas.conectar(v2, v1, 3);
	    islas.conectar(v2, v3, 2);
	    islas.conectar(v3, v2, 2);
	    islas.conectar(v3, v4, 4);
	    islas.conectar(v4, v3, 4);
	    islas.conectar(v3, v5, 8);
	    islas.conectar(v5, v3, 8);
	    islas.conectar(v5, v6, 9);
	    islas.conectar(v6, v5, 9);

	    islas.conectar(v1, v7, 11);
	    islas.conectar(v7, v1, 11);
	    islas.conectar(v7, v8, 1);
	    islas.conectar(v8, v7, 1);
	    islas.conectar(v8, v10, 1);
	    islas.conectar(v10, v8, 1);
	    islas.conectar(v7, v9, 15);
	    islas.conectar(v9, v7, 15);
	    islas.conectar(v7, v10, 1100);
	    islas.conectar(v10, v7, 1100);
	    Delta D = new Delta();

	    System.out.println("Maxima cantidad de islas que se pueden visitar: " + D.maxIslasDistintas(islas));
	   //funciona bien
	    
	    RutaMinima ruta = D.caminoMasCorto(islas, "Maldivas", "Jamaica");
	    
	    ListaGenerica<String> lista = ruta.getCamino();
	    System.out.println("Camino mas corto: ");
	    lista.comenzar();
	    while (!lista.fin()) {
	      System.out.println(lista.proximo());
	    }
	    //este no se si esta bien
	    System.out.println("Los boletos necesarios son: " + ruta.getBoletos());
	    
	    
	  }
	}