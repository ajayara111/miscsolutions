package myproj.mysoln;
public class TwoSum1 {
    public static int[] findTwoSum(int[] list, int sum) {
    	ArrayList al = new ArrayList [list]
    	int [] ret = new int [2];
        for (int i = 0; i < list.length; i++){
        	for (int j = 0; j < list.length; j++){
        		if (j != i){
        			if (sum- list[i] == list [j]){
        				ret[0] = i;
        				ret[1] = j;
        				return ret;
        				
        			}
        		}
        	}
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
        System.out.println(indices[0] + " " + indices[1]);
    }
}