/*
Given a decimal number m. Convert it in binary string and apply n iterations,
in each iteration 0 becomes 01 and 1 becomes 10. Find kth character in the
string after nth iteration.

The first line consists of an integer T i.e number of test cases.
The first and only line of each test case consists of three integers m,k,n. 

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GetKthChar {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i = 0; i < T; i++) {
		    int m = in.nextInt();
		    int k = in.nextInt();
		    int n = in.nextInt();

		    System.out.println(getKthChar(m,n,k));
		}

	}

	public static char getKthChar(int m, int n, int k) {
	    StringBuilder sb = new StringBuilder(Integer.toBinaryString(m));
	    StringBuilder nb;
	    for(int i = 0; i < n; i++) {
	        nb = new StringBuilder();
	        for(int j = 0; j < sb.length(); j++) {
	            if(sb.charAt(j) == '1') {
	                nb.append("10");
	            }
	            else {
	                nb.append("01");
	            }
	        }
	        sb = new StringBuilder(nb.toString());
	        //System.out.println(sb.toString());
	    }

	    return sb.charAt(k);
	}
}
