
public class Test180814 {
	public static void main(String[] args) {
		LinkedList<String> input = new LinkedList<>();
		
		input.addNode("a");
		input.addNode("b");
//		input.addNode("b");
//		input.addNode("c");
//		input.addNode("d");
//		input.addNode("b");
//		input.addNode("e");

		removeMidOfList(input);
		
		//System.out.println(test.removeNode(2));
		//LinkedList<String> result = removeDuplication(test);
	}
	
	public static <T> void removeMidOfList(LinkedList<T> input) {
		input.removeNode(input.size / 2);
		input.printNodes();
	}
}
