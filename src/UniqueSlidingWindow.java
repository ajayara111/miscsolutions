import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UniqueSlidingWindow {

	public int returnMaxUnique(int[] arr, int k) {
		int unique = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < arr.length; i++) {

			if (q.size() < k) {
				if (!q.contains(arr[i])) {
					unique++;
				}
				q.offer(arr[i]);
			} else {

				int remove = q.poll();
				if (!q.contains(remove)) {
					unique--;
				}
				
				if (!q.contains(arr[i])) {
					unique++;
				}
				q.offer(arr[i]);
			}
			if (q.size() == k) {
				if (unique == k) {
					return unique;
				}
			}
		}
		return unique;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();

		}
		UniqueSlidingWindow usw = new UniqueSlidingWindow();
		int num = usw.returnMaxUnique(arr, m);
		System.out.println (num);
	}
}
