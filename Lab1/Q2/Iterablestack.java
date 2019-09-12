
public class Iterablestack { //iterable stack + constructor and functions.
	static int head = 0;
	static int fixedSize = 20;
	static char[] stackarray = new char[fixedSize];

	public static void push(char c){ //pushes item to first array index and ++ the index
		stackarray[head] = c;
		head++;
	}

	public static char pop(){
		char c = stackarray[head-1];
		stackarray[--head]= 0; //sets the previous head to 0 and points to new head.
		return  c;  //return top of stack
	}
}
