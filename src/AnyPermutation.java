import java.util.ArrayList;

public class AnyPermutation {
	public boolean isPermPalin(ArrayList <Character> s){
		ArrayList<Character> temp = new ArrayList <Character>();
		for (Character c : s){
			if (temp.contains(c)){
				temp.remove(Character.valueOf(c));
			}
			else
				temp.add(c);
		}
		if (temp.size() <= 1){
			return true;
		}
		else 
			return false;
		
	}
	public static void main(String [] argv){
		AnyPermutation ap = new AnyPermutation();
		ArrayList<Character> val = new ArrayList<Character>();
		val.add('a');
		val.add('b');
		val.add('c');
		val.add('a');
		val.add('b');
		val.add('c');
		boolean x = ap.isPermPalin (val);
		int i;
		int v = 0;
		for ( i = 0; i < 10; i++){
		}
		 v= i;
		
	}

}
