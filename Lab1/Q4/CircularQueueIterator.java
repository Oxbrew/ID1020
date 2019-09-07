import java.util.*;

public class CircularQueueIterator<T> implements Iterator<T>{
Node<T> current;

	public CircularQueueIterator(CircularDLLS<T> linkedlist){
		current = linkedlist.getHead();
	}

	public boolean hasNext(){
		return current != null;
	}

	public T next(){
		T item = current.element;
		current = current.next;
		return item;
	}
}
