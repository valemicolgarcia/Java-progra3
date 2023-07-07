package practica2B;

public class Tablet2 extends Mobile{
	private int pulgadas;

	
public Tablet2 (String marca, String sistemaOperativo,  String modelo, double costo, int pulgadas) { //constructor vacio
	super(marca, sistemaOperativo, modelo, costo );	
	this.pulgadas = pulgadas;
		
	}	

public Tablet2 () { //constructor vacio
		
	}

public int getPulgadas() {
		return pulgadas;
	}


	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}

    //EQUALS
    public boolean equals (Object o) {
        boolean result = false;
        if ((o!=null) && (o instanceof Tablet2)) {
            Tablet2 t = (Tablet2) o; // casting
            //((Tablet2 o).getPulgadas()) -----opcionnnnnnnnnn
            if ( (super.equals(t)) && ( t.getPulgadas() == this.getPulgadas() )) {
                result = true;
            }
        }
        return result;
    }
    
    public String toString(){
    	 return (super.toString() + "Las pulgadas son: " + this.getPulgadas());
    	}
    
    
    
    







//-----------------------------------------------------------------------
}