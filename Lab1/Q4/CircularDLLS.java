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
