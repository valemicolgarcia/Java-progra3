package FigurasGeometricas;

public class Circulo extends Figura {
	protected double radio;
	
	//------------------------CONSTRUCTORES---------------------------------------------------
	public Circulo () {
		
	}
	
	public Circulo (double radio) {
		this.radio = radio; 
	}
	
	public Circulo (String color, boolean relleno, double radio) {
		super (color,relleno);
		this.radio = radio;
	}
	
	//--------------------------GETTERS AND SETTERS---------------------------------
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	//-----------------------ABSTRACT----------------------------------------------------------
	
	public double getArea () {
		double area = 0;
		area = ((3.14) * ( this.getRadio() * this.getRadio() ) ) ; //preguntar como se pone el cuadrado 
		return area;
	}
	
	public double getPerimetro () {
		double perimetro = 0;
		perimetro = ( (3.14) * (2* getRadio()) ) ; // 3.14 * diametro 
		return perimetro;
	}
	
	//-----------------------TO STRING------------------------------------------------------
	
	public String toString(){
   	 return (super.toString() + "El radio es: " + this.getRadio());
   	}
	

	
	//-------------------------------------------------------------------
}
