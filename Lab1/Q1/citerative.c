/*
*@author: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab1
*
*Input: Enter characters when running or redirect textfile
*Output: Reversed characters
*
*Goal: Use an iterative function in C to reverse characters.
*/


#include <stdio.h>

#define FIXEDSIZE 15
void iterativefunct(){  //creating interative function method
	char c;
	char array[FIXEDSIZE]; //declaring.
	int index = 0;

	while ((c = getchar()) != '\n') { //while input is not 'Enter'
		array[index++] = c; //add character to array and move index
	}

	for (int i = index; i >= 0; i--){ //Prints character in reverse order by accessing them from end to first
		putchar(array[i]);
	}

}

int main() {
	printf("Enter characters: ");
	iterativefunct();
	printf("\n");
	return 0;
}
