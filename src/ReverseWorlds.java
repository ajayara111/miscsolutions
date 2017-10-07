
public class ReverseWorlds {
	public void reverseWord(String s){
		String [] words = s.split(" ");
		String reversed = new String();
		//StringBuffer sb = new StringBuffer();
		for (int i = (words.length-1) ;i >= 0; i--){
			StringBuffer sb = new StringBuffer(words[i]);
			
			reversed =  reversed + sb.reverse().toString() + " ";
		}
		System.out.println(reversed);
	}
	public static void main (String [] argv){
		ReverseWorlds rw = new ReverseWorlds();
		rw.reverseWord("My Name is Khan");
		
	}

}
