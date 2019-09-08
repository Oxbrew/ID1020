import java.util.Iterator; 

public class ResizingArrayStack<Type> implements Iterable<Type>{ //Iterable tells that the class is Iterable
	
	private Type[] arr; //array for the types
	private int pos; //position/current "visible" size of the stack

	public ResizingArrayStack(){
		arr = (Type[]) new Object[10]; //create a new generic Type array of size 10
		pos = 0; 
	}

	//true if the stack is empty
	public boolean isEmpty(){
		return pos == 0;
	}
	
	//returns current size of Stack
	public int size(){
		return pos;
	}

	//returns real array size of Stack (how big the array itself is)
	public int arraySize(){
		return arr.length;
	}

	//for internal use - creates new array with size of 'newSize' and copies prev.
	private void resize(int newSize){
		Type[] temp = (Type[]) new Object[newSize]; //create a new generic Type-array with the size of new size

		for(int i = 0; i<this.pos; i++){ //loop up to pos as there are only that many elements
			temp[i] = arr[i];
		} 
		arr=temp; //change so that it points to the new, bigger array
	}

	//pushes a new item of type onto the stack
	public void push(Type t){
		if(this.pos == arr.length){ //if we have reached the end of the array
			resize(2*arr.length); //make the array twice as lbige
		}
		arr[pos] = t; //push t
		pos++; //increment pos
	}

	//removes an item
	public Type pop(){
		if(pos<=0){
			System.out.println("The array is empty");
			return null;
		}

		pos--; //as the push increments at the end, the pos is on the null after the last element
		arr[pos+1]=null; //avoid loitering

		if((pos == (arr.length/4)) && (pos>0)){ //if the stack is a quarter of the array (and it's not empty)
			resize(arr.length/2);//resize it to half as big
		}
		return arr[pos];
	}


	public Iterator<Type> iterator(){ //Iterator method
		return new ResizingArrayStackIterator();
	}

	private class ResizingArrayStackIterator implements Iterator<Type>{
		private int i = pos; //avoid changing pos itself
		public boolean hasNext() {return i>0;} //there is a next if the stack is not empty
		public Type next(){ return arr[--i];} //the next one is the previous element in the array
		public void remove(){}//clients should not use this 
	}

	public static void main(String[] args){
		ResizingArrayStack<Character> one = new ResizingArrayStack<Character>(); 

		one.push('h');
		one.push('e');
		one.push('l');
		one.push('l');
		one.push('o');

		// for(int i = one.size()-1; i>=0; i--){
		// 	System.out.println(one.pop());
		// }

		for(char i : one){
			System.out.println(i);
		}
		
	}
}