package my.experiment.code;

import java.util.List;
import java.util.Vector;

public class MaxConsequetive {
	public int getMaxConsequetive(int[] l) {
		int scorePrev = 0;
		int scoreFinal = 0;
		int scoreNow = 0;
		if (l.length == 1) {
			return l[0];
		} else {
			scorePrev = l[0];
			//scoreNow = scorePrev + l[1];
			for (int i = 1; i < l.length-1; i++) {
				
				scoreNow = scorePrev + l[i];
				if (scoreNow < scorePrev) {
					scoreFinal = scorePrev;
					scorePrev = l[i];
				}
				else{
					scorePrev = scoreNow;
				}
			}
		}
		return scoreFinal;

	}

	public static void main(String[] args) {
		MaxConsequetive mc = new MaxConsequetive();
		List<Integer> toExperiment = new Vector<Integer>();
		int[] toE = {1,2,-100,3};
		toExperiment.add(1);
		toExperiment.add(2);
		toExperiment.add(-100);
		toExperiment.add(5);
		int value = mc.getMaxConsequetive(toE);
		System.out.println("Value is" + value);

	}

}
