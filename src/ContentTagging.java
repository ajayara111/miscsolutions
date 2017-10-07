import java.util.Scanner;

public class ContentTagging {
	  public static void main(String[] args){
	      
	      Scanner in = new Scanner(System.in);
	      int testCases = Integer.parseInt(in.nextLine());
	      while(testCases>0){
	         String line = in.nextLine();
	         String [] splitStr = line.split(">");
	         for (int i = 0; i < splitStr.length; i++){
	        	 //Assuming every line start with a tag
	        	 //if 
	         }
	         
	         testCases--;
	      }
	   }
}
