/*
* @author Philipe Granhäll
* This program recieves an input and
*/
import java.util.*;

public class inputarray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(" Enter size of array: ");
		int nrElements = in.nextInt();

		int[] intarray = new int[nrElements];

		for (int i = 0;i < nrElements; i++ ) {
			System.out.println("Enter element: " + (i + 1));
			intarray[i] = in.nextInt();
		}

		for (int i = nrElements-1 ; i >= 0  ; i--) {
			System.out.println(intarray[i]);
		}
	}

}
