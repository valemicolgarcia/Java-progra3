package practica2;

public class Multiplos {
	
	
	public static int [] getMultiplos ( int n) {
		int arreglo [] = new int [n]; //creo el vector y guardo espacio en memoria.
		
		for (int i= 0; i<n; i++) {
			arreglo [i] = (i * n); // la cuenta esta mal hecha
			
		}
		return arreglo ;
	}
}
