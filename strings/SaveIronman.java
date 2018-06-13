// Given string check if palindrome, ignore the spl chars and whitespace.

/*package whatever //do not write package name here */

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class SaveIronman {
	public static void main (String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		in.nextLine();
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		while(T-->0) {
		    String s = "";
		    try {
		    	s = buf.readLine();
		    }
		    catch(Exception e){}

		    System.out.println(IsPalindrome(s) ? "YES" : "NO");
		}
	}
	
	private static boolean IsPalindrome(String s) {
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i = 0; i < s.length(); i++) {

	    	int ascii = s.charAt(i);

	    	if(ascii >= 65 && ascii <= 90) {
	  			
	    		sb.append((char)ascii);
	    	}
	    	else if(ascii >= 48 && ascii <= 57) {

	    		sb.append((char)ascii);
	    	}
	    	else if(ascii >= 97 && ascii <= 122) {

	    		ascii -= 32;
	    		sb.append((char)ascii);
	    	}

	    }

	    StringBuilder sb1 = new StringBuilder(sb);
	    sb.reverse();

	    //System.out.println("sb1 = " + sb1.toString() + "  sb = " + sb.toString());
	    
	    return (sb1.toString()).equals(sb.toString());
	}
}