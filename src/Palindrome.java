public class Palindrome {
	public static boolean isPalindrome(String word) {
		StringBuilder s = new StringBuilder(word);
		
			String word1 = s.reverse().toString().toLowerCase();
			if (word1.equals(word.toLowerCase())) {
				System.out.println("It is a palindrome");
				return true;
			}
		
		return false;
	}

	public static void main(String[] args) {
		System.out.println(Palindrome.isPalindrome("Deleveled"));
	}
}