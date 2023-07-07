package practica2B;

import java.util.Scanner;

public class EjercicioTestSobreescritura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in) ;
	/*	
		//LEO INFORMACION DE LA TABLET
		System.out.println("Ingrese marca: ");
		String marca = in.next();
		System.out.println("Ingrese sistema Operativo: ");
		String sisOp = in.next();
		System.out.println("Ingrese modelo: ");
		String modelo = in.next();
		System.out.println("Ingrese costo: ");
		int costo = in.nextInt();
		System.out.println("Ingrese pulgadas: ");
		int pulgadas = in.nextInt();
		*/
		//OBJETO TABLET
	//	Tablet2 t1 = new Tablet2 ("apple", "ios", "modelo", 10.0, 15); //instancio objeto tipo tablet
		//System.out.println(t1.toString()); //LLAMO AL TO STRING
		
		/*
		//LEO INFORMACION DEL SMARTPHONE
		System.out.println("Ingrese marca: ");
		String marca2 = in.next();
		System.out.println("Ingrese sistema Operativo: ");
		String sisOp2 = in.next();
		System.out.println("Ingrese modelo: ");
		String modelo2 = in.next();
		System.out.println("Ingrese costo: ");
		int costo2 = in.nextInt();
		
		
		System.out.println("Ingrese numero: ");
		int numero = in.nextInt();
		*/
		//OBJETO SMARTPHONE 1 
		Smartphone s1 = new Smartphone ("samsung", "ios", "modelo", 10.5, 15);
		System.out.println(s1.toString());
		
		Smartphone s2 = new Smartphone ("samsung", "ios", "modelo", 11, 15);
		//LEO INFO DEL SMARTPHONE 2
		/*System.out.println("Ingrese marca: ");
		String marca3 = in.next();
		System.out.println("Ingrese sistema Operativo: ");
		String sisOp3 = in.next();
		System.out.println("Ingrese modelo: ");
		String modelo3 = in.next();
		System.out.println("Ingrese costo: ");
		int costo3 = in.nextInt();
		System.out.println("Ingrese numero 2: ");
		int numero2 = in.nextInt();
		*/
		//OBJETO SMARTPHONE 2
	//	Smartphone s2 = new Smartphone (marca3, sisOp3, modelo3, costo3, numero2);
		System.out.println(s2.toString());
		
		//INVOCO AL METODO EQUALS
		System.out.println(s2.equals(s1)); 
		//si pongo el mismo numero me tira true
		//si pongo diferente numero me tira false
		
		
		
		//cierro el scanner
		in.close();
		
		
		
	}

}
