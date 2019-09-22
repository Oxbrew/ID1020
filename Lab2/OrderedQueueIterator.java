/*
*@author: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab2 Q7
*
*Input:Tests already implemented.
*Output: Printed current queue.
*
*Goal: Ordered Queue
*/


import java.util.*;
import java.lang.*;

public class OrderedQueueIterator implements Iterator<Integer>{
iNode current;

	public OrderedQueueIterator(OrderedQueue linkedlist){
		current = linkedlist.getHead();
	}

	public boolean hasNext(){
		return current != null;
	}

	public Integer next(){
		Integer item = current.element;
		current = current.next;
		return item;
	}
}
