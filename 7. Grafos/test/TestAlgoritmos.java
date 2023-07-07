
package grafos.test;

import grafos.Grafo;
//import grafos.Arista;
import grafos.Vertice;
//import prog3.listagenerica.*;
//import grafos.Grafo;
//import grafos.Arista;
//import prog3.listagenerica.ListaGenerica;
//import prog3.listagenerica.*;
import grafos.*;

public class TestAlgoritmos {
  public static void main(String args[]) {
    Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
    Vertice<String> v2 = new VerticeImplListAdy<String>("Cordoba");
    Vertice<String> v3 = new VerticeImplListAdy<String>("Rosario");
    Vertice<String> v4 = new VerticeImplListAdy<String>("Mendoza");
    Vertice<String> v5 = new VerticeImplListAdy<String>("La Plata");
    Vertice<String> v6 = new VerticeImplListAdy<String>("Mar del Plata");
    Vertice<String> v7 = new VerticeImplListAdy<String>("San Luis");
    Vertice<String> v8 = new VerticeImplListAdy<String>("San Juan");

    Grafo<String> grafo = new GrafoImplListAdy<String>();

    // Agregar los vértices al grafo
    grafo.agregarVertice(v1);
    grafo.agregarVertice(v2);
    grafo.agregarVertice(v3);
    grafo.agregarVertice(v4);
    grafo.agregarVertice(v5);
    grafo.agregarVertice(v6);
    grafo.agregarVertice(v7);
    grafo.agregarVertice(v8);

    // Conectar los vértices formando un ciclo
    grafo.conectar(v1, v2);
    grafo.conectar(v2, v3);
    grafo.conectar(v3, v4);
    grafo.conectar(v4, v1);

    // Conectar los vértices restantes en un orden aleatorio


    Algoritmos<String> a = new Algoritmos<String>();
    if (a.subgrafoCuadrado(grafo))
      System.out.println("El grafo es subgrafo cuadrado");
    else
      System.out.println("El grafo no es subgrafo cuadrado");
/*
    System.out.println("El grado del grafo es: " + a.getGrado(grafo));

    if (a.tieneCiclo(grafo))
      System.out.println("El grafo tiene ciclos");
    else
      System.out.println("El grafo no tiene ciclos");*/
    
    
  }
}