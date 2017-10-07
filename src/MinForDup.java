
public class MinForDup {
	public int minFordup(String s) {
		for (int i = 0; i < s.length(); i++) {
			// As soon as you find the duplicate return it
			if ((s.substring(i + 1, s.length()).indexOf(s.charAt(i)) != -1)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] argv) {
		MinForDup mfd = new MinForDup();
		System.out.println("The min is " + mfd.minFordup("asdfghjkz"));
	}
}
