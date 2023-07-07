package FigurasGeometricas;

public class Cuadrado extends Rectangulo {
	

	public Cuadrado () {
	}
	public Cuadrado (double lado) {
		super(lado,lado);
	}
	public Cuadrado (String color, boolean relleno, double lado) {
		super(color, relleno,lado,lado);
		
	}
	
//------------------GETTERS AND SETTERS----------------------------------------------
	
	public double getLado() {
		return super.getAncho();
	}

	public void setLado(double lado) {
		super.setAncho(lado);
		super.setLargo(lado);
	}
//--------------------------------------------------------------------------------------
/* no se como hacer estos!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
 
	public void setLargo(double largo) {
		super.setLargo(largo);
		super.setAncho(largo);
	}
	
	public void setAncho(double ancho){
		super.setLargo(ancho);
		super.setAncho(ancho);
		
	}
	
//------------------------TO STRING---------------------------------------------------
	public String toString(){
	   	 return ("El color es:" + super.color + "El relleno es: " + super.relleno + "El lado es: " + this.getLado() );
	   	}
	
//-----------------------------------------------------------------------------------------	
}
