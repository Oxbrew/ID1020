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

void recursivefunct() {
	char c;
	c = getchar();
	//scanf("%c", &c );

	if (c != '\n') {
		recursivefunct();
		putchar(c);
		//printf("%c\n", c );
	}
	printf("\n");
}
