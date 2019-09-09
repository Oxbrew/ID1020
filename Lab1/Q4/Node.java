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

public class Node<T> {
	T element;
	Node<T> next = null;

	public Node(T element, Node<T> next){
		this.element = element;
		this.next = next;
	}

	public T getElement(){
		return this.element;
	}

}
