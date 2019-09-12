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

public class Node<T> { //node class with creation methods
	T element;
	Node<T> next = null;
	Node<T> previous = null;

	public Node(T element){ //constructor to set data.
		this.element = element;
	}

	public T getElement(){ //method to return data of node.
		return this.element;
	}

}
