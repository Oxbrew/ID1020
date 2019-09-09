/*
*@author: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab1
*
*Input:Tests already implemented.
*Output: Printed current queue.
*
*Goal: Generic  Queue using double linked list being able to remove kth element
*/


import java.util.*;

public class QueueIterator<T> implements Iterator<T>{
Node<T> current;

	public QueueIterator(GenericDLLS<T> linkedlist){
		current = linkedlist.getHead();
	}

	public boolean hasNext(){
		return current != null;
	}

	public T next(){
		T item = current.getElement();
		current = current.next;
		return item;
	}
}
