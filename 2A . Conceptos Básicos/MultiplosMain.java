package practica2;
import java.util.Scanner; //importo el scanner
public class MultiplosMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in) ;
		
		System.out.println("Ingrese numero: ");
		int n = in.nextInt();
	
		
		int [] arreglo = Multiplos.getMultiplos (n);
		
		for (int i = 1; i < n; i++) {
			System.out.println(arreglo[i]);
		
	}
		in.close();
		
		
		
}
}
