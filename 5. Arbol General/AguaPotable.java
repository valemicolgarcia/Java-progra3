package arbolesGeneral;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class AguaPotable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		ArbolGeneral<Double> a = new ArbolGeneral<Double>(1.0);
		
		//revisar!!!!!!!!!!!!!!!!!!!
		ArbolGeneral <Double> a6 = new ArbolGeneral <Double> (83.3); //hoja
		ArbolGeneral <Double> a7 = new ArbolGeneral <Double> (83.3); //hoja
		ArbolGeneral <Double> a8 = new ArbolGeneral <Double> (83.3); //hoja
		ListaGenerica <ArbolGeneral<Double>> lista2 = new ListaGenericaEnlazada <ArbolGeneral<Double>> ();
		lista2.agregarFinal(a8);
		lista2.agregarFinal(a7); 
		lista2.agregarFinal(a6); 
		ArbolGeneral <Double> a5 = new ArbolGeneral <Double> (250.0); //hijo
		ArbolGeneral <Double> ax = new ArbolGeneral <Double> (250.0); //hijo
		ArbolGeneral <Double> ay = new ArbolGeneral <Double> (250.0); //hijo

		ArbolGeneral <Double> a4 = new ArbolGeneral <Double> (250.0 , lista2);//hijo
		ListaGenerica <ArbolGeneral <Double>> lista1 = new ListaGenericaEnlazada <ArbolGeneral <Double>> ();
		lista1.agregarFinal(a4); //
		lista1.agregarFinal(a5); //
		lista1.agregarFinal(ax); //
		lista1.agregarFinal(ay); //

		ArbolGeneral <Double> a3 = new ArbolGeneral <Double> (10.0, lista1);//raiz
		
		
		double c = caudal (a3,1000);
		System.out.println(c);
	}

	public static double caudal (ArbolGeneral<Double> a, double num) {
	//	double caudalmin = 9999.0;
		double caudalmin = Integer.MAX_VALUE; //valor maximo que puede representar una variable de tipo int en java 2^31-1.
		
		double actual; //caudal que estoy analizando
		double aux; //numero que voy dividiendo
		
		//recorrido preorden!!!!!!
		if (a.esHoja())
			caudalmin = num;
		else 
			if (a.tieneHijos()) {
				ListaGenerica <ArbolGeneral<Double>> l = a.getHijos(); //por que no enlazada???
				l.comenzar();
				aux = num / l.tamanio();
				while (!l.fin()) {
					actual = caudal (l.proximo(), aux);
					if (actual < caudalmin)
						caudalmin = actual;
			}
	}
	
		return caudalmin;
		//me devuelve 166.666666 y no 83.3 
		//ahora si  vamoooooooooooooooooooooooooooooo
	}
}
	
	

