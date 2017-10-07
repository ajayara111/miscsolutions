package my.experiment.code;

import java.util.ArrayList;

public class SearchN {
	public int findOccurance(ArrayList al, Integer x) {
		int ind = al.indexOf(x);
		int occurance = 0;
		if (ind != -1) {

			for (int i = ind; i < al.size(); i++) {
				if (al.get(ind) == x) {
					ind++;
					occurance++;

				} else {
					break;
				}
			}
		}
		return occurance;
	}

	public static void main(String[] argv) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(5);
		al.add(6);
		al.add(6);
		al.add(7);
		al.add(7);
		SearchN sn = new SearchN();
		System.out.println("value is" + sn.findOccurance(al, 5));

	}

}
