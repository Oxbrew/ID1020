/*
*@author: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab3 Q1
*
*Input: Text file
*Output: Only alphabetical characters from text file. Replacing any other symbol
*with a ' '.
*/


#include <stdio.h>
#include <ctype.h>

#define SIZE 100

char text[SIZE];
int current = 0;

char push(char c){
	text[current++] = c;
}

void printArray(char array[]){
	for (int i = 0; i < SIZE ; i++) {
		printf("%c", array[i] );
	}
}

void filter() {
	char c;
	while ((c = getchar()) != EOF) {
		if (isalpha(c))
			putchar(c);
		else
			putchar(' ');
	}

}

void main() {
	filter();
	/*char c;

	while ((c = getchar()) != EOF) {
		if (isalpha(c))
			push(c);
	 	else
			push(' ');
	}

	printArray(text);*/

}
