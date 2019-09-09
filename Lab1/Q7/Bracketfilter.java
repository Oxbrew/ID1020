import java.util.*;

public class Bracketfilter{

	public static boolean Bracketfilter(String text) {
		if (text.isEmpty()) {
			return false;
		}
		Stack stack = new Stack();
		char c;
		for (int i = 0;i < text.length() ; i++ ) {
			c = text.charAt(i);

			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty()) {
					return false;
				} else if (stack.peek() == '(') {
					stack.pop();
				} else {
					return false;
				}
			} else if (c == '}') {
				if (stack.isEmpty()) {
					return false;
				} else if (stack.peek() == '{') {
					stack.pop();
				} else {
					return false;
				}
			} else if (c == ']') {
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

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String read = in.nextLine();
		System.out.println(Bracketfilter(read));
	}
}
