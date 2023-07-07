package practica2B;

public class Smartphone extends Mobile {
	private int numero;

public Smartphone (String marca, String sistemaOperativo,  String modelo, double costo, int numero) { //constructor 
	super(marca, sistemaOperativo, modelo, costo );		
	this.numero = numero;
		}	



public Smartphone (){ //constructor vacío
		
	}


//-------------------------GETTERS Y SETTERS-------------------------
public int getNumero() {
	return numero;
	}

public void setNumero(int numero) {
	this.numero = numero;
	}
//------------------------METODOS DE INSTANCIA----------------------------

//EQUALS
public boolean equals (Object o) {
    boolean result = false;
    if ((o!=null) && (o instanceof Smartphone)) {
        Smartphone t = (Smartphone) o; // casting
        if ( (super.equals(t)) && ( t.getNumero() == this.getNumero() )) {
            result = true;

        }
    }
    return result;
}

//TO STRING
public String toString(){
	 return (super.toString() + "El numero es: " + this.getNumero());
	}


//------------------------METODOS DE CLASE----------------------------


}