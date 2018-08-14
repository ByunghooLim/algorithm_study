package CodingInterview.Chapter2;
import LinkedList.LinkedList;
import LinkedList.Node;

public class Test180814 {
	public static void main(String[] args) {
//		LinkedList<String> input = new LinkedList<>();
//
//		input.addNode("a");
//		input.addNode("b");
//		input.addNode("b");
//		input.addNode("c");
//		input.addNode("d");
//		input.addNode("b");
//		input.addNode("e");
		
		LinkedList<Integer> input = new LinkedList<>();
		
		input.addNode(1);
		input.addNode(2);
		input.addNode(3);
		input.addNode(4);
		input.addNode(5);
		input.addNode(6);
		input.addNode(7);

		// removeMidOfList(input);

		//divideInTwoLists(input, "c");
		
		divideInTwoLists(input, 4);

		// System.out.println(test.removeNode(2));
		// LinkedList<String> result = removeDuplication(test);
	}

	public static <T> void removeMidOfList(LinkedList<T> input) {
		input.removeNode(input.size / 2);
		input.printNodes();
	}

	public static <T extends Comparable<T>> void divideInTwoLists(LinkedList<T> input, T pivot) {
		LinkedList<T> left = new LinkedList<>();
		LinkedList<T> right = new LinkedList<>();

		Node<T> temp = input.head;

		while (true) {
			if (temp.data.compareTo(pivot) == 1 || temp.data.compareTo(pivot) == 0) {
				right.addNode(temp.data);
			} else {
				left.addNode(temp.data);
			}

			temp = temp.next;

			if (temp == null) {
				break;
			} else if (temp.next == null) {
				if (temp.data.compareTo(pivot) == 1 || temp.data.compareTo(pivot) == 0) {
					right.addNode(temp.data);
				} else {
					left.addNode(temp.data);
				}

				break;
			}
		}

		System.out.println("====== Left ======");
		left.printNodes();
		System.out.println("====== Right ======");
		right.printNodes();
	}
}
