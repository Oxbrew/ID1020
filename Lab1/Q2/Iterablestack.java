/*
*@author: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab1
*
*Input: Enter characters when running or redirect textfile
*Output: Reversed characters
*
*Goal: Use an Iterable function in java to reverse characters.
*/

public class Iterablestack {
	static int head = 0;
	static int fixedSize = 20;
	static char[] stackarray = new char[fixedSize];

	public static void push(char c){
		stackarray[head] = c;
		head++;
	}

	public static char pop(){
		char c = stackarray[head-1];
		stackarray[--head]= 0; //sets the previous head to 0 and points to new head.
		return  c;
	}
}
