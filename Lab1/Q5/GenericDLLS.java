import java.util.*;

public class GenericDLLS<T> implements Iterable<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;

	public boolean isEmpty(){
		return head == null;
	}

	public Node <T> getHead(){
		return head;
	}

	public Node <T> getTail(){
		return tail;
	}

	// Q5 Addition

	public Node<T> findElementAt(Node<T> reference, int position){
		Node<T> current = reference;
		for (int i = 1; i < position ; i++) {
			current = current.next;
		}
		return current;
	}
//****************************//
	public void printTheThing(){
		for (T element : this) {
			System.out.println(element);
		}
		System.out.println();
	}

	public void queue (T element){
		Node<T> newNode = new Node<>(element);

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
			this.size++;
		} else {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
			this.size++;
		}
	}

	public void deQueue(){
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

//Question 5, remove kth term.

	public void removeK(int index){
		Node<T> pointingAt = findElementAt(head, index);

		Node<T> previous = pointingAt.previous;
		Node<T> next = pointingAt.next;

		if (previous != null && next != null) {
			Node<T> temp = pointingAt.previous;
			temp.next = pointingAt.next;
			temp = pointingAt.next;
			temp.previous = pointingAt.previous;
			}

		if (previous == null) { // if it is the tail
			this.tail = pointingAt.next;
			this.tail.previous = null;
		}

		if (next == null) { // if it is the head
			this.head = pointingAt.previous;
			this.head.next = null;
		}

		if (isEmpty()) {
			throw new NoSuchElementException("Empty");
		} else if (this.size == 1) {
			head = null;
			tail = null;
			this.size--;
			System.out.println("Remaining node removed");
		}
	}

	//*****************************************************************************//


	public Iterator<T> iterator() {
		return new QueueIterator<T>(this); //this refers to the DLLS class
	}

}
