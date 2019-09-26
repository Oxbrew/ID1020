/*
*@author: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab2: Q8
*
*
*Input: From external file
*Output: Sorted integers
*
*Goal: mergesort
*/

/*
* Traditional mergesort that works by dividing into subgroups until it begins sorting itself and storing in
* a new array. Each time it does this it will combine with other sorted groups until whole group is sorted.
*/
#include <stdio.h>

void merge(int numbers[], int lo, int mid, int hi) {
	int temp[1000]; //specify size
	int i = lo;
	int j = mid + 1; //mid will be (hi + lo) / 2
	int k = 0;

	while (i <= mid && j <= hi) {
         if (numbers[i] <= numbers[j])
             temp[k++] = numbers[i++];
         else
             temp[k++] = numbers[j++];
     }
     while (i <= mid)
         temp[k++] = numbers[i++];

     while (j <= hi)
         temp[k++] = numbers[j++];

     k--;
     while (k >= 0) {
         numbers[lo + k] = temp[k];
         k--;
     }
 }

 void sort(int numbers[], int lo, int hi) {
    if (lo < hi) {
        int mid = (hi + lo)/2;
        sort(numbers, lo, mid); //left half
        sort(numbers, mid + 1, hi); // right half
        merge(numbers, lo, mid, hi); //merge sorted
    }
}

 void printArray(int numbers[], int size) {
 	int i;
 	for (i=0; i < size; i++)
 		printf("%d ", numbers[i]);
 	printf("n");
 }

void main() {
	int size = 1000;
	//scanf("%d", &size);
	int numbers[size];
	for (int i = 0; i < size; i++) {
		scanf("%d", &numbers[i]);
	}
	sort(numbers,0, size-1);

	printf("The following is sorted with mergesort: \n" );
	for (int i = 0; i < size; i++) {
		printf("%d, ", numbers[i]);
	}
}
