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
