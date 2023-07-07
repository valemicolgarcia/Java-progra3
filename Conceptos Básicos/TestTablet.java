package practica2;
import java.util.Scanner;

public class TestTablet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in) ;
		Tablet [] vector = new Tablet [3]; //arreglo de tres posiciones
		
		for (int i=0; i<3; i++) {
			System.out.println("Ingrese marca: ");
			String m = in.next();
			
			System.out.println("Ingrese Sistema Operativo: ");
			String so = in.next();
			
			System.out.println("Ingrese modelo: ");
			String modelo = in.next();
			
			System.out.println("Ingrese costo: ");
			double costo = in.nextDouble();
			
			System.out.println("Ingrese pulgadas: ");
			float pulgadas = in.nextFloat();
			
			vector [i] = new Tablet (m, so, modelo, costo, pulgadas); //creamos tres instancias de tablet
		}
		
		for (Tablet t: vector) {
			System.out.println (t.devolverDatos());
		}
		
		System.out.println("Instancias: " + Tablet.cuantasTablets() );
		
		in.close();
		
	}

}
