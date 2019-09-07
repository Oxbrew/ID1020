

import java.io.InputStreamReader;
import java.io.IOException;

public class Assignment2iterator{
    
    static char[] arr = new char[50];
    static int top = 0;
    public static void push(char c){
	arr[top] = c;
	top++;
	
    }

    public static char pop(){
	if(top == 0)
	    return 0;
	char c = arr[top-1];
	arr[top-1] = 0;
	top--;
	return c;
	    
    }
    
    
    public static void main(String[] args) throws IOException{
	InputStreamReader in = new InputStreamReader(System.in);
	char c;
	while(true){
	    c = (char) in.read();
	    if(c == '\n')
		break;
	    push(c);
	   
	}
	System.out.println();
	while(top > 0)
	    System.out.print(pop());
	System.out.println();
    }
}
