package myproj.mysoln;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ListWithinAList {
	/*
	 * Complete the function below.
	 */
	 
	   static boolean find(int sum, int[] arr) {
	        ArrayList<Integer> arrayList = new ArrayList<Integer>();
	        
	        for (int i = 0; i < arr.length; i++){
	            if (arrayList.contains((sum - (arr[i])))){
	                return true;
	            }
	              
	  return false;
	       

	    }

	static boolean is_all_items_in_list(String[] L, String[] M) {
		ArrayList <String> ls = new ArrayList <String>();
		ArrayList <String> lm = new ArrayList <String>();
		
		for (int i = 0; i < L.length; i++){
			ls.add(L[i]);
		}
		for (int i = 0; i < M.length; i++){
			lm.add(M[i]);
		}
		return Collections.disjoint(ls, lm);
		

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
	
		boolean res;

		int _L_size = 0;
		_L_size = Integer.parseInt(in.nextLine().trim());
		String[] _L = new String[_L_size];
		String _L_item;
		for (int _L_i = 0; _L_i < _L_size; _L_i++) {
			try {
				_L_item = in.nextLine();
			} catch (Exception e) {
				_L_item = null;
			}
			_L[_L_i] = _L_item;
		}

		int _M_size = 0;
		_M_size = Integer.parseInt(in.nextLine().trim());
		String[] _M = new String[_M_size];
		String _M_item;
		for (int _M_i = 0; _M_i < _M_size; _M_i++) {
			try {
				_M_item = in.nextLine();
			} catch (Exception e) {
				_M_item = null;
			}
			_M[_M_i] = _M_item;
		}

		res = is_all_items_in_list(_L, _M);
		
	}
}
