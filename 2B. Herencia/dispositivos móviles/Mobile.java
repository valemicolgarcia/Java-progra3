package practica2B;


public class Mobile {

	private String marca;
	private String sistemaOperativo;
	private String modelo;
	private double costo;
	private static int cantidad;
	
	
	public Mobile (String marca, String sistemaOperativo,  String modelo, double costo){
	 	this.marca = marca;
	 	this.sistemaOperativo = sistemaOperativo;
	 	this.modelo = modelo;
	 	this.costo = costo; 
	 	Mobile.cantidad += 1; //la conocen todas las instancias porq esta en la clase, no se puede poner this
	}
	
	public Mobile() {
		
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
	
	
	public String devolverDatos () {
		String aux; 
	    aux = "Marca: " + marca + ". Sistema operativo: " + sistemaOperativo + ". Modelo: " + modelo + ". Costo: " + costo;
	    return aux;
	}
	
	public static int cuantosMobiles() {
		return cantidad; 
		
	}
	
	
	 //EQUALS
    public boolean equals (Object o) {
        boolean result = false;
        if ((o!=null) && (o instanceof Mobile)) {
            Mobile m = (Mobile) o; // castea
            if ( (m.getMarca() == this.getMarca()) &&  ( m.getSistemaOperativo() == this.getSistemaOperativo()) &&
                    ( m.getModelo() == this.getModelo()) && (m.getCosto() == this.getCosto() )){
                result = true;
            }
        }
        return result;
    }
	
    public String toString () {
		String aux; 
	    aux = "Marca: " + marca + ". Sistema operativo: " + sistemaOperativo + ". Modelo: " + modelo + ". Costo: " + costo;
	    return aux;
	}
	
	
}
