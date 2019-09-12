public class Node<T> { //node class with constructors.
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
