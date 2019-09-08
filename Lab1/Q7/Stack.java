public class Stack {
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

	public static char peek(){
		return stackarray[head];
	}
}
