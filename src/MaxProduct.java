
public class MaxProduct {
	public int getMax (int[] arr){
		int maxSoFar = arr[0];
		int prodNow = arr[0];
		for (int i = 1; i < arr.length; i++){
			prodNow = prodNow * arr[i];
			if (prodNow > maxSoFar){
				maxSoFar = prodNow;
			}
		}
		return maxSoFar;
		
	}
	public static void main (String [] argv){
		
	}

}
