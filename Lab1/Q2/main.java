import java.util.*;

public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(" Enter size: ");
		int nrChars = in.nextInt();

		Stack <Character> stack = new Stack<Character>(nrChars);

		for (int i = 0; i < nrChars ; i++ ) {
			System.out.println("Enter character: " + (i+1));
			stack.push(in.nextChar());

		}
		for (int i = stack.size; i >= 0; i--){
			System.out.println(stack.pop(i));
		}

	}

}
