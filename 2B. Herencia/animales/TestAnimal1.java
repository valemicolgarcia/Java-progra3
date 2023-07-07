package Animales;

public class TestAnimal1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("TEST 1");
		Gato donGato = new Gato();
		donGato.saludo();
		Perro benji = new Perro();
		benji.saludo();
		PerroGrande lassie = new PerroGrande();
		lassie.saludo();
		
		//Indique qué obtuvo como salida luego de la ejecución de TestAnimal1
		//Miau!
		//Guau!
		//Guauuuuuu!

		System.out.println(lassie.esMasBuenoQue (donGato));
		//si se puede 

	}

}
