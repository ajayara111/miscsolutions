import java.util.ArrayList;

public class StringJustification {
	String[] textJustification(String[] words, int L) {
	    ArrayList<String> listofString = new ArrayList<String>();
	    int len =0;
	    String consolidateString = new String();;
	    for (String s: words){
	    	len = len + s.length() +1 ;
	        if (len <= L){
	            consolidateString = consolidateString+ " " + s;
	        }
	        else{
	        	listofString.add(consolidateString);
	        	consolidateString = new String();
	        	consolidateString = s;
	        	listofString.add (consolidateString);
	        	len = s.length();
	        }
	    }
	    
	    return (String[])(listofString.toArray());

	}
	public static void main (String[] argv){
		String [] words = {"This", "is", "an", "example", "of", "text", "justification."};
		StringJustification sj = new StringJustification();
		String [] sts = sj.textJustification(words, 16);
		for (String s: sts){
			System.out.println(s);
		}
	}
}
