/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class CountElements {
	public static void main (String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		while(T-->0) {
		    
		    int N = in.nextInt();
		    
		    int a[] = new int[N];
		    int b[] = new int[N];
		    
		    for(int i = 0; i < N; i++) { a[i] = in.nextInt(); }
		    for(int i = 0; i < N; i++) { b[i] = in.nextInt(); }
		    
		    int freq[] = new int[101];
		    
		    for(int i = 0; i < N; i++) { freq[b[i]]++; }
		    
		    int cum[] = new int[101];
		    cum[0] = freq[0];
		    for(int i = 1; i < 101; i++) { cum[i] = cum[i-1] + freq[i]; }
		    
		    for(int i = 0; i < N; i++) { 

		    	if(i == 0)
		    		System.out.print(cum[a[i]]);
		    	else
		    		System.out.print("," + cum[a[i]]); 
		    }
		    
		    System.out.println();
		}
	}
}