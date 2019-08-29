#include <stdio.h>

int main(int argc, char const *argv[]) {

	int nrElements;

	scanf("%d", &nrElements);

	int inputarray [nrElements];

	for (int i = 0; i < nrElements; i++) {
		printf("%s", "Enter number: " );
		scanf("%d", &inputarray[i]);
	}

	for (int i = nrElements -1; i >= 0; i--) {
		printf("%d\n", inputarray[i] );
	}




	return 0;
}
