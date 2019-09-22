/*
*@author: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab2 Q5 + Q6
*
*Input: Array of ints
*Output: Array seperated by negative and positives.
*/


#include <stdio.h>

void swap(int numbers[],int i , int j){  //Swapping function
  int temp = numbers[i];
  numbers[i] = numbers[j];
  numbers[j] = temp;
}


//main function seperating negative and positive numbers.
void separate(int numbers[], int size){
	int lo = 0;
	for (int i = 0; i < size; i++) {
		if ( numbers[i] <= 0) { //if number is negative or equal to 0
			if (i != lo) { // And if i does not equal lo for the indexes.
				swap(numbers, i, lo);
			}
			if (lo != 0  && numbers[lo-1] == 0) { //check for if previous number is 0 so that all positive numbers are seperated by a 0
				swap(numbers, lo, lo-1);
			}

			lo++; //else increase lo index.
		}
	}
}
/*
After each loop, all numbers before 'lo' will be negative.
*/


//function to print.
void printArray(int numbers[], int size){
	for (int i = 0; i < size; i++) {
		printf("%d ", numbers[i]);
	}
}

int main() {
	int numbers[] = {-2,5,4,3,0,-1,-5,-6,9,0};
	int size = sizeof(numbers) / sizeof(numbers[0]); //gets size of array.
	printf("%s\n", "Before:" );
	printArray(numbers, size);

	separate(numbers, size);
	printf("%s\n", "After: " );
	printArray(numbers, size);

	return 0;
	}
