/*
*@author: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab1
*
*Input:Tests already implemented.
*Output: Printed current queue.
*
*Goal: Generic FIFO Queue using circular double linked list.
*/

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
