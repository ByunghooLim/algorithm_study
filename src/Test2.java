import java.util.Set;
import java.util.TreeSet;

public class Test2 {
	static Set<Integer> tree = new TreeSet<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		int[] array = { -2, -1, 0, 1, 2 };
		getAllSums(array, 0, 0);
		tree.remove(0);
		for (Integer i : tree)
			System.out.println(i);

	}

	public static void getAllSums(int[] numbersArray, int starting, int sum) {
		if (numbersArray.length == starting) {
			tree.add(sum);
			return;
		}

		int value = sum + numbersArray[starting];

		getAllSums(numbersArray, starting + 1, value);
		getAllSums(numbersArray, starting + 1, sum);
	}
}
