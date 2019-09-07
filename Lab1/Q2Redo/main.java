import java.io.*;

public class main {

		public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in);
		Iterablestack iterable = new Iterablestack();
		char c;
		while(c != '\n'){
			c = (char) in.read();
			iterable.push(c);
		}
		System.out.println("Reversed: ");

		while(iterable.head > 0){
			System.out.println(iterable.pop());
		}

		System.out.println('\n');
		}

}
