
public class Palindrom {
	  public static boolean isPalindrome(String word) {
	        StringBuffer sb = new StringBuffer(word);
	        if (((sb.reverse()).toString().toLowerCase()).equals(word.toLowerCase())){
	            return true;
	        }
	        else 
	            return false;
	        
	    }
	    
	    public static void main(String[] args) {
	        System.out.println(Palindrome.isPalindrome("Deleveled"));
	        System.out.println(Palindrome.isPalindrome("abbAaaa"));
	    }
}
