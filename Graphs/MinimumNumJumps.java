// https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps/0/

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumNumJumps 
{
	public static void main (String[] args) {
	    
	    Scanner in = new Scanner(System.in);
	    
	    int T = in.nextInt();
	    
	    while(T-->0) {
	        
	        int N = in.nextInt();
	        
	        int arr[] = new int[N];
	        
	        for(int i = 0; i < N; i++) {
	            
	            arr[i] = in.nextInt();
	        }
	        
	        PrintNumJumps(arr, N);
	    }
	}
	
	private static void PrintNumJumps(int arr[], int N) {
	    
	    int jumps = -1;
	    
	    boolean v[] = new boolean[N];
	    v[0] = true;
	    
	    Queue<Node> q = new LinkedList<>();
	    Node p = new Node(0,0);
	    q.add(p);
	    
	    while(!q.isEmpty()) {
	        
	        p = q.remove();
	        int idx = p.idx;
	        int dist = p.dist;
	        
	        if(idx == N-1){
	            jumps = dist;
	            break;
	        }
	        
	        int k = arr[idx];
	        for(int i = 1; i <= k; i++) {
	            
	            if(N > idx+i && !v[idx+i]) {
	                v[idx+i] = true;
	                
	                q.add(new Node(idx+i, dist+1));
	            }
	        }
	    }
	    
	    System.out.println(jumps);
	}
	
}

class Node {
    
    int idx;
    int dist;
    
    public Node(int idx, int dist){
        this.idx = idx;
        this.dist = dist;
    }
}