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
}
