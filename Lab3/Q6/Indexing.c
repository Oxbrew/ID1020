/*
*@author: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab3 Q6
*
*Input: Text file
*Output: Character index of all occurences of word.
*
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

void compareWord(char word[], int size){
	int lastChar;
	int index = -1; //Assuming we want first char index in text to be 1.
	int matchIndex = 0;
	int matchArray[10000]; //being able to store 10,000 occurences of a word.
	int temp = 0; //the 'start counting' variable.
	int counter = 0; //counter for matcharry
	int c = getchar(); //getchar returns an int.
	index++;
	while ((lastChar = c) != EOF) {
		c = getchar();
		if (c == '\n')
			index += 2;
		else
			index++;
		if ((!isalpha(lastChar) || lastChar == ' ') && c == word[0]) { //if the previous character is a space or is not a character as well as c being match.
				temp = index; //start counting.
			for (int i = 1; i <= size; i++) {
				lastChar = c;
				c = getchar();
				if (c == '\n')
					index += 2; //\n counts as two indexes.
				else
					index++;
				if (c != word[i]) //if c does not match the word break.
					break;
				}
				if ((!isalpha(c) || c == ' ') && lastChar == word[size-1]) { //if c is not a char or c is a space AND previous character matches the last letter of word.
					matchIndex++; //then the word is finished.
					matchArray[counter++] = temp;
				}
			}
		}
		for (int i = 0; i < matchIndex; i++) {
			printf("Found at index: %d\n", matchArray[i]);
		}
	}
//Note, hardcoded search terms.
	int main(){
		char word[6] = {"always"};
		compareWord(word, 6);
	}
