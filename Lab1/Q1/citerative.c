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
