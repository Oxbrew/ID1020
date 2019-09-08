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
