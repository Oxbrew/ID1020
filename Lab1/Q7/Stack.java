/*
*@author: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab1
*
*Input: Enter characters when running or redirect textfile
*Output: Text where :: True = Balanced || False = Unbalanced.
*
*Goal: A filter which determines if paranthesis is balanced.
*/

public class Stack {
	static int head = 0;
	static int size = 20;
	static char[] stackarray = new char[size];

	public static void push(char c){
		stackarray[head] = c;
		head++;
	}

	public static char pop(){
		char c = stackarray[head-1];
		stackarray[--head]= 0; //sets the previous head to 0 and points to new head.
		return  c;
	}

	public static char peek(){
		return stackarray[head-1];
	}

	public boolean isEmpty(){
		return (head == 0);
	}
}
