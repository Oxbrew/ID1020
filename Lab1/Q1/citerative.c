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
