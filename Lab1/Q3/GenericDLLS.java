import java.util.*;

public class GenericDLLS<T> implements Iterable<T> { //implements iterable interface
	private Node<T> head;
	private Node<T> tail;
	private int size;
//methods for information
	public boolean isEmpty(){
		return head == null;
	}

	public Node <T> getHead(){
		return head;
	}

	public Node <T> getTail(){
		return tail;
	}
//uses iterator to print.
	public void printTheThing(){
		for (T element : this) {
			System.out.println(element);
		}
		System.out.println();
	}

//adds to queue
	public void queue (T element){
		Node<T> newNode = new Node<>(element); //create new node

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
			this.size++;
		} else {
			newNode.next = head; //draw on board...
			head.previous = newNode;
			head = newNode;
			this.size++;
		}
	}

	public void deQueue(){ //removed end of queue.
		if (isEmpty()) {
			throw new NoSuchElementException("Empty");
		} else if (this.size == 1) {
			head = null;
			tail = null;
			this.size--;
			System.out.println("Remaining node removed");
			} else {
			tail = tail.previous;
			tail.next.previous = null;
			tail.next = null;
			this.size--;
			}
	}

	public Iterator<T> iterator() { //iterator class that implements iterator interface.
		return new QueueIterator<T>(this); //this refers to the DLLS class
	}

}
