package practica2;

public class Tablet {
	private String marca;
	private String sistemaOperativo;
	private String modelo;
	private double costo;
	private float pulgadas;
	private static int cantidad;
	
	public Tablet (String marca, String sistemaOperativo,  String modelo, double costo, float pulgadas){
	 	this.marca = marca;
	 	this.sistemaOperativo = sistemaOperativo;
	 	this.modelo = modelo;
	 	this.costo = costo;
	 	this.pulgadas = pulgadas; 
	 	Tablet.cantidad += 1; //la conocen todas las instancias porq esta en la clase, no se puede poner this
	}
	
	public Tablet () {
		
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getSistemaOperativo() {
		return sistemaOperativo;
	}
	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public float getPulgadas() {
		return pulgadas;
	}
	public void setPulgadas(float pulgadas) {
		this.pulgadas = pulgadas;
	}
	
	public String devolverDatos () {
		String aux; 
	    aux = "Marca: " + marca + ". Sistema operativo: " + sistemaOperativo + ". Modelo: " + modelo + ". Costo: " + costo + ". Pulgadas:  " + pulgadas;
	    return aux;
	}
	
	public static int cuantasTablets() {
		return cantidad; 
		}
		
}
