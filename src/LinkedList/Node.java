package LinkedList;

public class Node<T> {
	public T data;
	public Node<T> next;

	public Node(T input) {
		this.data = input;
		this.next = null;
	}
}
