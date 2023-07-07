package arboles.arbol;

public class ArbolesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArbolBinario<Integer> arbolBinario=new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> hijoIzquierdo=new ArbolBinario<Integer>(2);
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<Integer>(4));
		ArbolBinario<Integer> hijoDerecho=new ArbolBinario<Integer>(6);
		hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		hijoDerecho.agregarHijoDerecho(new ArbolBinario<Integer>(8));
		arbolBinario.agregarHijoIzquierdo(hijoIzquierdo);
		arbolBinario.agregarHijoDerecho(hijoDerecho);
		
		
		preOrden (arbolBinario);
	}
	
	public static void preOrden (ArbolBinario<Integer> a) {
		
		System.out.println(a.getDato());
		if (a.tieneHijoIzquierdo())
			preOrden (a.getHijoIzquierdo());
		if (a.tieneHijoDerecho())
			preOrden (a.getHijoDerecho());
		
	}

}
