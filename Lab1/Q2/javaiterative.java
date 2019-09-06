import java.util.*;

public class LinkedListStack<T> implements Iterable<T> {
	public Iterator<T> iterator(){

		return new LinkedListIterator<T>();
		Node<T> current = head;

		public boolean hasNext(){
			return current != null;
		}

		public T next(){
			Node next = current;
			current = current.next;
			return next.T
		}
	}


}
	private Node head;

	private class Node {
		private T charinput;
		private Node next;
	}

	private void Push (T charinput){
		Node current = head;
		head = new Node();
		head.charinput = charinput;
		head.next = current;
	}
	private T Pop () {
		T temp = head.charinput;
		head = head.next;
		return temp;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Node current = head;
		while (current != null) {
			sb.append(current.charinput).append(" ");
			current = current.next;
		}
		return sb.toString();
	}
}

public class javaiterative {
	public static void main(String[] args) {
		Stack<String> stack = new  LinkedListStack<String>();	}
}
