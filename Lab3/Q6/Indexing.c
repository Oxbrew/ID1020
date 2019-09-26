#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void compareWord(char word[], int size){
	char c;
	int index = -1;
	while ((c = getchar()) != EOF) {
		index++;
		if (c == word[0]) {
			char storing = c;
			char otherWord[size];
			otherWord[0] = c;
			for (int i = 1; i < size ; i++) {
					otherWord[i] = (storing = getchar());
					index++;
			}
			if (((storing = getchar()) ==' ')|| (storing == '\n')  && (strcmp(word, otherWord) == 0)){
				index++;
				int wordIndex = index;
				wordIndex -= size;
				printf("%d \n", wordIndex);
			} else
				index++;
			}
		}
	}

int main() {
	/*printf("Enter the size of the word to index: " );
	int size;
	scanf("%d", &size);
	printf("Now enter the word you are looking: " );
	char word[size];

	scanf("%s", word);

	compareWord(word, size);*/

	char word[] = "the";
	compareWord(word, 3);
}
