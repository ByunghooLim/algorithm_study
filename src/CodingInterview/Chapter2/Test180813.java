package CodingInterview.Chapter2;
import LinkedList.LinkedList;
import LinkedList.Node;

public class Test180813 {
	public static void main(String[] args) {
		LinkedList<String> test = new LinkedList<>();

		test.addNode("a");
		test.addNode("b");
		test.addNode("b");
		test.addNode("c");
		test.addNode("d");
		test.addNode("b");
		test.addNode("e");

		System.out.println(getNodeFromBack(6, test).data);
		// LinkedList<String> result = removeDuplication(test);

	}

	public static LinkedList<String> removeDuplication(LinkedList<String> input) {
		Node<String> temp = input.head;

		while (true) {
			String str = temp.data;

			Node<String> nextNode = temp;

			while (true) {
				Node<String> currentNode = nextNode.next;

				if (currentNode.data.equals(str)) {
					nextNode.next = currentNode.next;
				}

				if (currentNode.next == null) {
					if (currentNode.data.equals(str))
						currentNode.next = null;
					break;
				}

				nextNode = currentNode;
			}

			temp = temp.next;

			if (temp.next == null) {
				break;
			}
		}

		return input;
	}

	public static <T> Node<T> getNodeFromBack(int k, LinkedList<T> input) {
		if (input.size <= k)
			throw new IndexOutOfBoundsException();

		return input.getNode(input.size - (k + 1));
	}
}
