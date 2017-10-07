
public class ReverseWord {
	public String getReverse(String s){
		String returnVal = new String();
		String[] numS = s.split(" ");
		for (int i = numS.length -1; i >=0; i--){
			returnVal = returnVal +  numS[i] + " ";
		}
		return returnVal;
	}
	public static void main (String [] argv){
		ReverseWord  rw = new ReverseWord();
		String s = rw. getReverse("Man bites dog");
		System.out.println(s);
	}

}
