import java.util.*;

public class CircularDLLS<T> implements Iterable<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;

	public CircularDLLS(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public boolean isEmpty(){
		return head == null;
	}

	public Node <T> getHead(){
		return head;
	}

	public Node <T> getTail(){
		return tail;
	}

	public void printTheThing(){

		Node<T> counter = head;

		do {
			System.out.println(counter.element);
			counter = counter.next;
		} while (counter != head);

		System.out.println();
	}


	public void queueHead(T element){
		Node<T> newNode = new Node<>(element, head);

		if (isEmpty()) {
			head = tail = newNode;
			head.next = tail;
			tail.next = head;
			this.size++;

		} else {
			tail.next = newNode;
			head = newNode;
			this.size++;
		}
	}


	public void queueTail(T element){
		Node<T> newNode = new Node<>(element, head);

		if (isEmpty()) {
			head = tail = newNode;
			head.next = tail;
			tail.next = head;
			this.size++;

		} else {
			tail.next = newNode;
			tail = newNode;
			this.size++;
		}
	}


	public void deQueueHead(){
		if (isEmpty()) {
			throw new NoSuchElementException("Empty");
		} else {
			tail.next = head.next;
			head = head.next;
			this.size--;
			}
	}

	public void deQueueTail(){
		if (isEmpty()) {
			throw new NoSuchElementException("Empty");
		} else {
			Node<T> search = head;
			while (search.next != tail) {
				search = search.next;
			}
			tail = search;
			tail.next = head;
			this.size--;

			}
	}

	public Iterator<T> iterator(){
		return new CircularQueueIterator<T> (this);
	}
}
