import java.util.*;

public class QueueIterator<T> implements Iterator<T>{ //iterable interface with methods + constructors
Node<T> current;

	public QueueIterator(GenericDLLS<T> linkedlist){ //instantiates iterator.
		current = linkedlist.getHead();
	}
//below are points required to keep track of position using the double linked list.
	public boolean hasNext(){
		return current != null;
	}

	public T next(){
		T item = current.getElement();
		current = current.next;
		return item;
	}
}
