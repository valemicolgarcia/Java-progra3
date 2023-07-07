package Animales;

public class TestAnimal2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("TEST 2");
		Animal donGato = new Gato();
		donGato.saludo();
		Animal benji = new Perro();
		benji.saludo();
		Animal lassie = new PerroGrande();
		lassie.saludo();
		
		//Analice en el código la diferencia entre TestAnimal1 y TestAnimal2 e indique
		//qué obtuvo como salida luego de la ejecución de TestAnimal2.
		/*TEST 2: la diferencia esta en que se definen de tipo animal, no de tipo gato, perro, etc...
			Miau!
			Guau!
			Guauuuuuu!
		 			       */
		
		//System.out.println(lassie.esMasBuenoQue (benji));
		// no se puede porque no esta definido para tipo animal, no esta visible
		
		
		
		
		
		
		
		
	}

}
