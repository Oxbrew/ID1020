/*
*@author: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab1
*
*Input:Tests already implemented.
*Output: Printed current queue.
*
*Goal: Generic FIFO Queue using double linked list.
*/

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

	public Iterator<T> iterator() {
		return new QueueIterator<T>(this); //this refers to the DLLS class
	}

}
