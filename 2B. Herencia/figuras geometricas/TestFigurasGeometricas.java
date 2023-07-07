package FigurasGeometricas;
import java.util.Scanner;

public class TestFigurasGeometricas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		Figura [] vector = new Figura [3]; //creo vector de tres figuras
		
		//LEO INFO DEL CIRCULO-------------------------------
		System.out.println(" LEO INFO DEL CIRCULO:  \n");
		System.out.println("     \n");
		
		System.out.println("Ingrese color: \n");
		String color = in.next();
		System.out.println("Ingrese si esta relleno o no: \n");
		boolean relleno = in.nextBoolean();
		System.out.println("Ingrese radio  \n");
		double radio = in.nextDouble();
		
		//LEO INFO DEL RECTANGULO-------------------------------
		System.out.println(" LEO INFO DEL RECTANGULO: ");
		System.out.println("     ");
		
		System.out.println("Ingrese color: \n");
		String color2 = in.next();
		System.out.println("Ingrese si esta relleno o no: \n");
		boolean relleno2 = in.nextBoolean();
		System.out.println("Ingrese ancho  \n");
		double ancho = in.nextDouble();
		System.out.println("Ingrese largo  \n");
		double largo = in.nextDouble();
		
		//LEO INFO DEL CUADRADO-------------------------------
		System.out.println(" LEO INFO DEL CUADRADO:  \\n");
		System.out.println("     \n");
		
		System.out.println("Ingrese color: \n");
		String color3 = in.next();
		System.out.println("Ingrese si esta relleno o no: \n");
		boolean relleno3 = in.nextBoolean();
		System.out.println("Ingrese lado");
		double lado = in.nextDouble();
	
	
		//almaceno objetos de tipo figura en el vector--------------------------
		vector[0] = new Circulo(color, relleno, radio);
		vector[1]= new Rectangulo(color2, relleno2, ancho, largo);
		vector[2] = new Cuadrado(color3, relleno3, lado);
		
		
		
		
		//llamo al to string---------------------------------------
		for (Figura v: vector) {
			System.out.println (v.toString());
		}
		
		in.close();
		//--------------------------------------------------------
	}

}
