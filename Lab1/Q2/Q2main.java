/*
*@author: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab1
*
*Input: Enter characters when running or redirect textfile
*Output: Reversed characters
*
*Goal: Use a recursive function in java to reverse characters.
*/


import java.io.*;

public class Q2main {

		public static void main(String[] args) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		Iterablestack iterable = new Iterablestack();
		char c;
		while(true){
			c = (char) in.read();
			if (c == '\n') {
				break;
			}
			iterable.push(c);
		}
		System.out.println("Reversed: ");

		while(iterable.head > 0){
			System.out.println(iterable.pop());
		}

		System.out.println('\n');
		}

}
