package java8;

public class ChangeAscii {
	public String toAlphabetic(int i){
		  if( i<0 ) {
		        return "-"+toAlphabetic(-i-1);
		    }

		    int quot = i/26;
		    int rem = i%26;
		    char letter = (char)((int)'a' + rem);
		    if( quot == 0 ) {
		        return ""+letter;
		    } else {
		        return toAlphabetic(quot-1) + letter;
		    }
		
	}
	public static void main(String[] argv){
		ChangeAscii changeAscii = new ChangeAscii();
		System.out.println(changeAscii.toAlphabetic(4));
		System.out.println(changeAscii.toAlphabetic(56));
		System.out.println(changeAscii.toAlphabetic(560));
		System.out.println(changeAscii.toAlphabetic(561));
	}

}
