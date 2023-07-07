package arbolesGeneral;

public class Empleado {
	private String nombre;
	private int antiguedad;
	private int categoria;
	
	//CONSTRUCTOR VACIO
	public Empleado (String nombre, int antiguedad, int categoria) {
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.categoria = categoria;
    }
	public Empleado (){
		//constructor vacio
	}
	
	//----------------GETTERS AND SETTERS-----------------------
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

}
