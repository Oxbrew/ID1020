
public class InsertionSort {

	static void InsertionSort(int array[]){
		int size = array.length;

		for (int i = 1; i < size ; ++i ) {
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

	static void makeNegative(int array[]){
		for (int i = 0;i < array.length ; i++ ) {
			array[i] = array[i] * -1;
		}
	}

	static void SortInsertionSort(int array[]){
		int size = array.length;
		int counter = 0;

		for (int i = 1; i < size ; ++i ) {
			int key = array[i];
			int j = i-1;
			while (j >= 0 && (array[j] > key)) {
				array [j + 1] = array [j];
				counter ++;
				j--;
			}
			array[j + 1] = key;
		}
		System.out.println("Steps: " + counter);
	}

	static void InversionCounter(int array[]){
		int size = array.length;
		int counter = 0;
		for (int i = 1; i < size; i++ ) {
			for (int j = i-1 ; j >= 0 ; j-- ) {
				if (array[i] < array[j]) {
					System.out.println("Inversion: [" + i + "," + array[i] + "] " + " [" + j + "," + array[j] + "]");
					counter++;
				}
			}
		}
		System.out.println(counter);
	}


	public static void main(String[] args) {
		int array[] = {2,4,35,16,12,14,15,1,0,-2};

		System.out.println("Before: ");
		printArray(array);

		InsertionSort(array);

		System.out.println("After: ");
		printArray(array);

		System.out.println("Descending Order:");

		int descending[] = {2,4,35,16,12,14,15,1,0,-2};
		printArray(descending);

		makeNegative(descending);
		InsertionSort(descending);
		makeNegative(descending);

		printArray(descending);

		int steps[] = {2,4,35,16,12,14,15,1,0,-2};
		printArray(steps);
		SortInsertionSort(steps);
		printArray(steps);

		int inversion[] = {5,1,2,3,4};
		printArray(inversion);
		InversionCounter(inversion);
		InsertionSort(inversion);
		printArray(inversion);


	}
}
