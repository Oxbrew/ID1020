/*
*@author: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab2: Q8 + Q9
*
*
*Input: From external file
*Output: Sorted integers
*
*Goal: Quicksort + Quicksort with insertionsort.
*/

#include<stdio.h>

void swap(int* a, int* b){
  int temp = *a;
  *a = *b;
  *b = temp;

}
void printArray(int numbers[], int size)
{
	int i;
	for (i=0; i < size; i++)
		printf("%d ", numbers[i]);
	printf("n");
}
// classic partiion where we separate numbers smaller than pivot and greater than by placeing them to the left and right respectively.
int partition (int numbers[], int low, int high)
{
	int pivot = numbers[high]; // Starting by setting pivot to last element in array
	int i = (low-1); // Index of smaller element

	for (int j = low; j <= high - 1; j++)
	{
		if (numbers[j] < pivot) // If element at jth index is smaller than pivot (correct position)
		{
			i++; // increment i pointer by 1.
			swap(&numbers[i], &numbers[j]); //swap the numbers at i and j
		}
	}
	swap(&numbers[i + 1], &numbers[high]); //end partion by swapping the i+1th term with highest term(pivot)
	return (i + 1); //return index
}



void quickSort(int numbers[], int low, int high) {
	if (low >= high) return;
		int part = partition(numbers, low, high);

		quickSort(numbers, low, part - 1);
		quickSort(numbers, part + 1, high);
}

//Q9 insertion sort:

void insertionSort(int * numbers, int size){

	for (int i = 1; i < size; i++) {
		int key = numbers[i];
		int j = i - 1;
		while (j >= 0 && numbers[j] > key) {
			numbers[j + 1] = numbers[j];
			j--;
		}
		numbers[j+1] = key;
	}
}

void insertionQuickSort(int numbers[], int low, int high) {
		if (high <= low) return; //indicates sorted
		if (high - low <= 30) { //cut off at 30.
			insertionSort(numbers, high-low+1);
			return;
		} else { //traditional quickSort.
			int part = partition(numbers, low, high);
			//Recursive calls
			insertionQuickSort(numbers, low, part - 1);
			insertionQuickSort(numbers, part + 1, high);
		}
}

void main() {
	int size = 100000;   //hardcoded array size
	//scanf("%d", &size);
	int numbers[size];
	for (int i = 0; i < size; i++) {
		scanf("%d", &numbers[i]);
	}
	quickSort(numbers, 0, size-1);
	//insertionQuickSort(numbers, 0 , size-1);

	printf("The following is sorted with quickSort: \n" );
	for (int i = 0; i < size; i++) {
		printf("%d, ", numbers[i]);
	}
}
