package ejercicio4P2B;

public class PruebaRetorno {
	
	public static Datos ProcesarArreglo (int[] vector) {
		
		int max = -1, min = 9999;
		int suma = 0;
		for (int i = 0; i< vector.length ; i++) {
			if (vector[i] > max)
					max = vector [i];
			if (vector [i] < min)
					min = vector [i];
			suma += vector[i];
		
		}
		double prom;
		prom = (double)suma / vector.length; 
		
		Datos obj = new Datos ();
		obj.setMax (max);
		obj.setMin (min);
		obj.setProm (prom);
		
		return obj;
		
	}
	
}
