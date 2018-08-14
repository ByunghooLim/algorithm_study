import java.util.ArrayList;
import java.util.Comparator;

public class Hacker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] a = { { -1, -1, 0, -9, -2, -2 }, { -2, -1, -6, -8, -2, -5 }, { -1, -1, -1, -2, -3, -4 },
				{ -1, -9, -2, -4, -4, -5 }, { -7, -3, -3, -2, -9, -9 }, { -1, -3, -1, -2, -4, -5 } };

		hourglassSum(a);
	}

	static int birthdayCakeCandles(int[] ar) {
		ArrayList<Integer> arrayList = new ArrayList<>();

		for (int a : ar) {
			arrayList.add(a);
		}

		arrayList.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		return arrayList.lastIndexOf(arrayList.get(0)) + 1;
	}

	static String timeConversion(String s) {
		if (s.contains("AM"))
			if (s.startsWith("12"))
				return s.replace("AM", "").replace("12", "00");
			else
				return s.replace("AM", "");
		else {
			if (s.startsWith("12"))
				return s.replace("PM", "");
			else {
				String tempStr = s;
				int hour = Integer.parseInt(tempStr.substring(0, 2));
				int newHour = hour + 12;

				if (newHour == 24)
					newHour = 0;

				String newHourStr;

				if (newHour < 10)
					newHourStr = "0" + newHour;
				else
					newHourStr = "" + newHour;

				return newHourStr + s.substring(2, s.length() - 2);
			}
		}
	}

	static int[] gradingStudents(int[] grades) {
		for (int i = 0; i < grades.length; i++) {
			int grade = grades[i];

			if (grade < 38) {
				continue;
			}

			int rest = 5 - (grade % 5);

			if (rest > 3)
				grade += rest;

			grades[i] = grade;
		}

		return grades;
	}

	static int hourglassSum(int[][] arr) {
		final int size = arr.length - 2;

		int result = 0;
		int tempResult = 0;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < 3; k++) {
					tempResult += arr[i][j + k];
					tempResult += arr[i + 2][j + k];
				}

				tempResult += arr[i + 1][j + 1];

				if ((i == 0 && j == 0) || (tempResult > result))
					result = tempResult;

				tempResult = 0;
			}
		}

		return result;
	}

}
