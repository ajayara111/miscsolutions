import java.util.ArrayList;
import java.util.Scanner;

public class IceCreamProblem {
	public void chooseFlavor(int mon, ArrayList<Integer> id) {
		for (int i = 0; i < id.size(); i++) {
			int indexn = id.indexOf(mon - id.get(i));
			if ((indexn != -1) && (indexn != i)) {
					if (i < indexn)
					System.out.println((i + 1) + " " + (indexn +1));
					else
						System.out.println((indexn +1) + " " + (i +1));
					break;
			
			}
		}

	}

	public static void main(String[] argv) {
		IceCreamProblem icp = new IceCreamProblem();
		Scanner in = new Scanner(System.in);
		int round = in.nextInt();
		for (int i = 0; i < round; i++) {
			// get the money
			int mon = in.nextInt();
			int idNum = in.nextInt();
			ArrayList<Integer> idArray = new ArrayList<Integer>(idNum);
			for (int j = 0; j < idNum; j++) {
				idArray.add(in.nextInt());
			}
			icp.chooseFlavor(mon, idArray);

		}
	}

}
