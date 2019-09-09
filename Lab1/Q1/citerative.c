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
void iterativefunct(){
	char c;
	char array[FIXEDSIZE];
	int index = 0;

	while ((c = getchar()) != '\n') {
		array[index++] = c;
	}

	for (int i = index; i >= 0; i--){
		putchar(array[i]);
	}

}

int main() {
	printf("Enter characters: ");
	iterativefunct();
	printf("\n");
	return 0;
}
