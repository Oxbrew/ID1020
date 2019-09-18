import java.io.*;

public class main {

		public static void main(String[] args) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in); //stream reader allows for character by charcter reading
		Iterablestack iterable = new Iterablestack(); //creating an Iterablestack object
		char c;
		while(true){ //essentially do, while.
			c = (char) in.read(); //c = keyboard input
			if (c == '\n') { //until it = ' enter'
				break;
			}
			iterable.push(c); //push onto stack
		}
		System.out.println("Reversed: ");

		while(iterable.head > 0){
			System.out.println(iterable.pop()); //reverse by popping and printing. due to how a stack is built this results in reverse order
		}

		System.out.println('\n');
		}

}
