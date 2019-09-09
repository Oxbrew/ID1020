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

public class Node<T> {
	T element;
	Node<T> next = null;
	Node<T> previous = null;

	public Node(T element){
		this.element = element;
	}

	public T getElement(){
		return this.element;
	}

}
