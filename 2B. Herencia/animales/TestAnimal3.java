package Animales;

public class TestAnimal3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TIPO PERRO, GATO, PERRO GRANDE
		Gato gato1 = new Gato();
		gato1.saludo();
		Perro perro1 = new Perro();
		perro1.saludo();
		PerroGrande perroGrande1 = new PerroGrande();
		perroGrande1.saludo();
		
		// TIPO ANIMAL
		
		/*UPCASTING:  la conversión es hacia arriba en la jerarquía de herencia y se pierde el tipo específico 
		  del objeto. SE EJECUTA el metodo asociado con el objeto al que hace referencia la variable en ejecución
		 (en este caso gato)     */
	
		Animal animal1 = new Gato(); //UPCASTING
		animal1.saludo();
	
		Animal animal2 = new Perro(); //UPCASTING 
		animal2.saludo();
		
		Animal animal3 = new PerroGrande(); //UPCASTING
		animal3.saludo();
		
		
		//DOWNCASTING----------------------------------------------------------------------------------------
		Perro perro2 = (Perro)animal2; //DOWNCASTING: a animal2 le recupero su tipo 
		
		PerroGrande perroGrande2 = (PerroGrande)animal3; 
		
		Perro perro3 = (PerroGrande) animal3; 
		
		Gato gato2 = (Gato)animal1;
		
		//----------------------------------------------------------------------------------
		perro2.saludo(perro3);
		perro3.saludo(perro2);
		perro2.saludo(perroGrande2);
		perroGrande2.saludo(perro2);
		perroGrande2.saludo(perroGrande1);
		
		
		
		
		
		
		
	}

}
