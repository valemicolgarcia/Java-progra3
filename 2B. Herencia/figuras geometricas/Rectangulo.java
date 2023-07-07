package FigurasGeometricas;

public class Rectangulo extends Figura {
	protected double ancho;
	protected double largo;
	
	//-----------------CONSTRUCTORES-----------------------------------------------------
	
	public Rectangulo () {
		
	}
	
	public Rectangulo (double ancho, double largo) {
		this.ancho = ancho;
		this.largo = largo;
	}
	
	//-------------------constructor agregado---------------preguntar------------------
	/*public Rectangulo (String color, boolean relleno) {
		super (color, relleno);
	}*/
	//------------------------------------------------------------
	
	public Rectangulo (String color, boolean relleno,double ancho, double largo) {
		super (color, relleno);
		this.ancho = ancho;
		this.largo = largo;
	}
	
	//-----------------GETTERS AND SETTERS------------------------------------------------
	
	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}
	
	//-----------------------ABSTRACTS------------------------------------------------------
	
	public double getArea () {
		double area= ( this.getAncho() * this.getLargo() );
		return area;
	}
	
	public double getPerimetro () {
		double perimetro = ( (2 * this.getAncho ()) + (2 * this.getLargo()) );
		return perimetro;
		
	}
	//-----------------------TO STRING---------------------------------------------------------
	
		public String toString(){
	   	 return (super.toString() + "El largo es: " + this.getLargo() + "El ancho es: " + this.getAncho());
	   	}
	
	//---------------------------------------------------------------------------------------
}
