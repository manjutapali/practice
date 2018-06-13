/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class CountSetUnsetBits {
	public static void main (String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		while(T-->0) {
		    
		    int num = in.nextInt();
		    
		    int n = num;
		    
		    int count = 0;
		    
		    while(n > 0) {
		        n = n & (n-1);
		        count++;
		    }
		    
		    n = num;
		    
		    for(int i = 1; i <= n; i = i<<1) {
		        
		        if((i & n) == 0)
		            count++;
		    }
		    
		    System.out.println(count);
		}
	}
}