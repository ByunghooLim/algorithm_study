package LinkedList;

public class LinkedList<T> {
	public Node<T> head;
	public Node<T> tail;
	public int size = 0;

	private void addFirst(T input) {
		Node<T> newNode = new Node<>(input);

		head = newNode;
		tail = head;
		size++;
	}

	public void addNode(T input) {
		Node<T> newNode = new Node<>(input);

		if (head == null) {
			addFirst(input);
		} else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}

	public Node<T> getNode(int idx) {
		if (size <= idx)
			throw new IndexOutOfBoundsException();

		Node<T> prev = head;

		for (int i = 0; i < size; i++) {
			if (idx == i)
				return prev;
			else {
				prev = prev.next;
			}
		}

		return null;
	}

	public boolean removeNode(int idx) {
		if (size <= idx)
			throw new IndexOutOfBoundsException();

		Node<T> prev = head;

		if (idx == 0) {
			head = head.next;
			return true;
		}

		for (int i = 0; i < size; i++) {
			if (idx - 1 == i) {
				prev.next = prev.next.next;
				size--;
				return true;
			} else {
				prev = prev.next;
			}
		}

		return false;
	}

	public void printNodes() {
		Node<T> temp = head;

		while (true) {
			System.out.println(temp.data);
			temp = temp.next;

			if (temp == null) {
				break;
			} else if (temp.next == null) {
				System.out.println(temp.data);
				break;
			}
		}
	}
}
