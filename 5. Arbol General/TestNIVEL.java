package arbolesGeneral;
import prog3.arboles.*;
import prog3.listagenerica.*;


public class TestNIVEL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//creo los nodos
		
		//empleados------------------------
		Empleado e1 = new Empleado ("Vale", 19, 4);
		ArbolGeneral <Empleado> a6 = new ArbolGeneral <Empleado> (e1); //empleado
		Empleado e2 = new Empleado ("Loli", 23, 4);
		Empleado e3 = new Empleado ("Taci", 19, 4);
		ArbolGeneral <Empleado> a7 = new ArbolGeneral <Empleado> (e2); //empleado
		ArbolGeneral <Empleado> a8 = new ArbolGeneral <Empleado> (e3); //empleado
		ListaGenerica <ArbolGeneral<Empleado>> empleados = new ListaGenericaEnlazada <ArbolGeneral<Empleado>> ();
		empleados.agregarFinal(a8); //taci
		empleados.agregarFinal(a7); //vale
		empleados.agregarFinal(a6); //loli
		//subgerentes------------------------------------------
		Empleado e4 = new Empleado ("Joa", 19, 3);
		Empleado e5 = new Empleado ("Joaco", 19, 3);
		ArbolGeneral <Empleado> a5 = new ArbolGeneral <Empleado> (e5); //sub-gerente
		ArbolGeneral <Empleado> a4 = new ArbolGeneral <Empleado> (e4 , empleados);//sub-gerente
		ListaGenerica <ArbolGeneral <Empleado>> subGerentes = new ListaGenericaEnlazada <ArbolGeneral <Empleado>> ();
		subGerentes.agregarFinal(a4); //joaco g
		subGerentes.agregarFinal(a5); //joaco l
		//gerentes
		Empleado e6 = new Empleado ("Peter", 19, 2);
		Empleado e7 = new Empleado ("Bauti", 19, 2);
		ArbolGeneral <Empleado> a3 = new ArbolGeneral <Empleado> (e6, subGerentes);//sub-gerente
		ListaGenerica <ArbolGeneral <Empleado>> gerentes = new ListaGenericaEnlazada <ArbolGeneral <Empleado>> ();
		ArbolGeneral <Empleado> a2 = new ArbolGeneral <Empleado> (e7); //gerente
		gerentes.agregarFinal(a3);//peter
		gerentes.agregarFinal(a2); //bau
		//presidente
		Empleado e8 = new Empleado ("Tibu", 19, 1);
		ArbolGeneral <Empleado> a1 = new ArbolGeneral <Empleado> (e8, gerentes);//presidente
		
		ListaGenericaEnlazada<Empleado> resultado = a1.porNiveles();
		System.out.println(resultado.elemento(0).getNombre());
		System.out.println(resultado.elemento(1).getNombre());
		System.out.println(resultado.elemento(2).getNombre());
		System.out.println(resultado.elemento(3).getNombre());
		System.out.println(resultado.elemento(4).getNombre());
		System.out.println(resultado.elemento(5).getNombre());
		System.out.println(resultado.elemento(6).getNombre());
		System.out.println(resultado.elemento(7).getNombre());
		
		//categorias 1,2,3,4
		Empresa e = new Empresa(a1);
		int nro = e.empleadosPorCategoria(4);
		System.out.println("El nro de empleados es " + nro);
		//funciona bien
		int cat = e.categoriaConMasEmpleados();
		System.out.println("La categoria con mayor numero de empleados es la nro: " + cat);
		//creo que funciona bien
		int total = e.cantidadTotal();
		System.out.println("La cantidad total de empleados es: " + total);
		//funciona
	//	e.reemplazarPresidente();
		System.out.println("Se reempelza el presiuu");
		
		
		
		System.out.println(resultado.elemento(0).getNombre());
		System.out.println(resultado.elemento(1).getNombre());
		System.out.println(resultado.elemento(2).getNombre());
		System.out.println(resultado.elemento(3).getNombre());
		System.out.println(resultado.elemento(4).getNombre());
		System.out.println(resultado.elemento(5).getNombre());
		System.out.println(resultado.elemento(6).getNombre());
		
		
	}


}
