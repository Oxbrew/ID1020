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
