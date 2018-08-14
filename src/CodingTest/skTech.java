package CodingTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class skTech {
	private static Set<List<Integer>> answer = new HashSet<>();
	private static int N;
	private static List<Integer> numbers = new ArrayList<>();

	public static void main(String[] args) {
		N = 4;

		for (int i = -N + 1; i < N; i++)
			numbers.add(i);
		
//		for (int i = 0; i < N; i++) {
//			if(i == 0)
//				numbers.add(0);
//			else {
//				numbers.add(i);
//				numbers.add(i * -1);
//			}
//		}
			

		dfs(0, new ArrayList<Integer>(), 0);

		for (List<Integer> list : answer) {
			System.out.println(list);
		}
	}

	public static void dfs(int idx, List<Integer> list, int sum) {
		if (sum == 0 && list.size() == N) {
			answer.add(new ArrayList<>(list));
			return;
		} else {
			for (int i = idx; i < numbers.size(); i++) {
				list.add(numbers.get(i));
				dfs(i + 1, list, sum + numbers.get(i));
				list.remove(list.size() - 1);
			}
		}
	}
}
