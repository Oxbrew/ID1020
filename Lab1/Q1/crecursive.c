#include <stdio.h>
/*
*
*/
void recursivefunct();

int main() {

	printf("Enter characters: ");
	recursivefunct();

	return 0;
}

/* NOTE: by using getchar() we are able to use the same variable name
* 'c' without it being overwritten. This is because when getchar is called it
* moves forward in memory by (int) bits (8)
*
* putchar() allows us to do the reverse whilst printing it.
*
* The same works with scanf and printf stdin and stout functions.;
*/

void recursivefunct() {
	char c;
	c = getchar(); // char = input from keyboard
	//scanf("%c", &c );

	if (c != '\n') {  //while c is not 'enter' call recursive funct
		recursivefunct(); //does not overwrite the previous c
		putchar(c); // when 'enter' is reached, start printing.
		//printf("%c\n", c );
	}
	printf("\n");
}
