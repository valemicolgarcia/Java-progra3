package ejercicio4P2B;

public class TestPruebaRetorno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] vector = {3,7,7,7,0};
		Datos maxminprom = PruebaRetorno.ProcesarArreglo(vector);
		
		System.out.println("El m�ximo es " + maxminprom.getMax());
		System.out.println("El m�nimo es " + maxminprom.getMin());
		System.out.println("El promedio es " + maxminprom.getProm());
	}
		
		
		
	}


