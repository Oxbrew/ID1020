/*
*@author: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab1
*
*Input:Tests already implemented.
*Output: Printed current queue.
*
*Goal: Ordered Queue
*/


import java.util.*;

public class OrderedQueue implements Iterable<Integer> {
	private iNode head;
	private iNode tail;
	private int size;

	public OrderedQueue(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public boolean isEmpty(){
		return head == null;
	}

	public iNode getHead(){
		return head;
	}

	public iNode getTail(){
		return tail;
	}

	public void printTheThing(){
		for (Integer element : this) {
			System.out.println(element);
		}
		System.out.println();
	}
//method implemented to find the element bigger than current.
	public iNode findBiggerElement(int number){
		iNode current = head;
		while(current.getElement() <= number){
			current = current.next;
		}
		return current;
	}
//when adding nodes I order directly by using the find findBiggerElement.
	public void Queue(int element){
		iNode temp = new iNode(element);

		if (isEmpty()) {
			this.head = this.tail = temp;
			return;
		} else if (temp.getElement() > tail.getElement()) {
			tail.next = temp;
			temp.previous = tail;
			tail = temp;
		} else if (temp.getElement() < head.getElement()) {
			head.previous = temp;
			temp.next = head;
			head = temp;
		} else {

		iNode bigElement = findBiggerElement(element);
//draw on board.
		temp.previous = bigElement.previous;
		temp.next = bigElement;
		temp.next.previous = temp;
		temp.previous.next = temp;
		}
	}

	public void deQueue(){
		if (isEmpty()) {
			System.out.println("Empty");
			return;
		} else {
			iNode temp = this.head;
			this.head = this.head.next;
			if (isEmpty()) {
				this.tail = null;
			}
			return;
		}
	}

	public Iterator<Integer> iterator(){
		return new OrderedQueueIterator(this);
	}
}
