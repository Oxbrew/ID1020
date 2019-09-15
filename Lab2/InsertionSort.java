
public class InsertionSort {

	static void InsertionSort(int array[]){
		int size = array.length;

		for (int i = 1;i < size ; ++i ) {
			int key = array[i];
			int j = i-1;

			while (j >= 0 && (array[j] > key)) {
				array [j + 1] = array [j];
				j--;
			}
			array[j + 1] = key;
		}
	}

	static void printArray(int array[]){
		int size = array.length;
		for (int i = 0;i < size ; i++ ) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int array[] = {2,4,35,16,12,14,15,1,0,-2};

		System.out.println("Before: ");
		printArray(array);

		InsertionSort(array);

		System.out.println("After: ");
		printArray(array);
	}

}
