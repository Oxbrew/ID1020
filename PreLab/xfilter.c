#include <stdio.h>

int main(int argc, char const *argv[]) {
	char letter;
	while ((letter = getchar())!= EOF) {
		if (letter == 'a' || letter == 'A') {
			putchar('X');
		}
		else {
			putchar(letter); // writes to console
		}
	}
	return 0;
}
