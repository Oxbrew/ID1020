#include <stdio.h>

void separate(int numbers[], int size){
	int lo = 0;
	for (int i = 0; i < size; i++) {
		if ( numbers[i] < 0) { //if number is negative
			if (i != lo) { // And if i does not equal lo for the indexes.
				int temp = numbers[i];
				numbers[i] = numbers[lo];
				numbers[lo] = temp;
			}
			lo++; //else increase lo index.
		}
	}
}

void printArray(int numbers[], int size){
	for (int i = 0; i < size; i++) {
		printf("%d ", numbers[i]);
	}
}

int main() {
	int numbers[] = {-2,5,4,3,0,-1,-5,-6,9};
	int size = sizeof(numbers) / sizeof(numbers[0]);
	printf("%s\n", "Before:" );
	printArray(numbers, size);

	separate(numbers, size);
	printf("%s\n", "After: " );
	printArray(numbers, size);

	return 0;
	}
