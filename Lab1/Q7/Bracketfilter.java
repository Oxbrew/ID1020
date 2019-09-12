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


import java.util.*;

public class Bracketfilter{

	public static boolean Bracketfilter(String text) { //method to filter
		if (text.isEmpty()) {
			return false;
		}
		Stack stack = new Stack(); //create new stack object
		char c;
		for (int i = 0;i < text.length() ; i++ ) {
			c = text.charAt(i); //for each element entered...

			if (c == '(' || c == '{' || c == '[') { //push if the charcter is a bracket
				stack.push(c);
			} else if (c == ')') { //check required for each end bracket.
				if (stack.isEmpty()) {
					return false;
				} else if (stack.peek() == '(') { //check if stack corresponds to a completed bracket.
					stack.pop();
				} else {
					return false;
				}
			} else if (c == '}') { //check
				if (stack.isEmpty()) {
					return false;
				} else if (stack.peek() == '{') {
					stack.pop();
				} else {
					return false;
				}
			} else if (c == ']') { //check
				if (stack.isEmpty()) {
					return false;
				} else if (stack.peek() == '[') {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) { //using scanner to enter long line of brackets.
		Scanner in = new Scanner(System.in);
		String read = in.nextLine();
		System.out.println(Bracketfilter(read));
	}
}
