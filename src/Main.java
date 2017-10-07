import java.util.ArrayList;
import java.util.HashMap;

// Class name must be "Main"

class Main {
	public static void main(String[] args) {
		findTriplet(new int[] { 12, 3, 4, 1, 6, 9 }, 24);

		System.out.println("Hello, world!");
	}

	public static void findTriplet(int[] arr, int sum) {
		// To keep all the tuple addition
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();

		// Pseudo code
		// Go through the integers

		// Create the list and arrayList of the integers
		// Add all the combination of couple of them
		// This will take n2 time
		// Now put all of them in a hashtable
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				// Don't want to put the addition to itself.
				if (j != i) {
					ArrayList<Integer> al = new ArrayList<Integer>();
					al.add(arr[i]);
					al.add(arr[j]);
					hm.put(arr[i] + arr[j], al);
				}
			}
		}

		// Now go through the array again and
		// Do a sum - arr[i], if this exists we have a find

		for (int i = 0; i < arr.length; i++) {
			// Got the match so print it
			if (hm.get(sum - arr[i]) != null) {
				ArrayList<Integer> al1 = hm.get(sum - arr[i]);
				System.out.println("true" + "," + al1.get(0) + "'" + al1.get(1) + "," + arr[i]);
				// We dont want to continue after getting the first match
				break;
			}

		}

	}

}
