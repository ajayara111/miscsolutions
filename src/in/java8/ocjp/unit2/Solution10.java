package in.java8.ocjp.unit2;

import java.util.Scanner;

public class Solution10 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a0 = in.nextInt();
		int a1 = in.nextInt();
		int a2 = in.nextInt();
		int b0 = in.nextInt();
		int b1 = in.nextInt();
		int b2 = in.nextInt();

		int countA = 0;
		int countB = 0;
		if (a0 > b0) {
			countA += 1;
		}

		if (b0 < a0)
			countB += 1;
		if (a1 > b1)
			countA += 1;

		if (b1 < a1)
			countB += 1;
		if (a2 > b2)
			countA += 1;

		if (b2 < a2)
			countB += 1;

		System.out.println(countA + " " + countB);
	}

}
