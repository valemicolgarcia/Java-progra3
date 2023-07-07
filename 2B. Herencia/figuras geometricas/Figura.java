package FigurasGeometricas;

public abstract class Figura {
	
	protected String color;
	protected boolean relleno;
	
	
	//-------------------------------CONSTRUCTORES------------------------------------------
	
	public Figura (String color, boolean relleno) { 
		this.color = color;
		this.relleno = relleno;
		
		}
	public Figura () { //constructor vacio
		
	}
	//----------------------------GETTERS Y SETTERS-------------------------------------------------
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isRelleno() {
		return relleno;
	}
	public void setRelleno(boolean relleno) {
		this.relleno = relleno;
	}
	//------------------------------------------------------------------------------------------
	
	abstract double getArea();
	abstract double getPerimetro ();
	
	//-----------TO STRING------------------------------------------------
	
	public String toString () {
		String aux;
		aux= "El color es: " + color + " y la condicion de relleno es: " + relleno;
		return aux;
	}
	//----------------------------------------------------------------------
}
