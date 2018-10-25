import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {

        Scanner in = new Scanner();
        int T = in.nextInt();

		while(T-->0) {

		    int r = in.nextInt();
		    int c = in.nextInt();

		    int a[r][c] = new int[r][c];

		    for(int i = 0; i < r; i++) {

		        for(int j = 0; j < c; j++) {

		            arr[i][j] = in.nextInt();
		        }
		    }

		    System.out.println(GetCost(arr, r, c));
		}
	}

	private static int GetCost(int m[][], int r, int c) {

	    Queue<Pair> q = new Queue<Pair>();
	    Pair t;

	    int cost = 0;

	    for(int i = 0; i < r; i++) {
	        for(int j = 0; j < c; j++) {
	            if(m[i][j] == 2)
	                q.add(new Pair(i, j));
	        }
	    }

	    q.add(new Pair(-1, -1));

	    while(!q.isEmpty()) {

	        boolean flag = false;

	        while(!((q.peek().x == -1) && (q.peek().y == -1))) {
	            t = q.peek();

	            if(isValid(t.i + 1, t.j) && m[t.i+1][t.j] == 1) {

	                if(!flag) {
	                    cost++;
	                    flag = true;
	                }

	                m[t.i+1][t.j] = 2;

	                q.add(new Pair(t.i+1, t.y));
	            }

	            if(isValid(t.i, t.j-1) && m[t.i][t.j-1] == 1) {

	                if(!flag) {
	                    cost++;
	                    flag = true;
	                }

	                m[t.i][t.j-1] = 2;

	                q.add(new Pair(t.i, t.j-1));
	            }

	            if(isValid(t.i, t.j+1) && m[t.i][t.j+1] == 1) {

	                if(!flag) {
	                    cost++;
	                    flag = true;
	                }

	                m[t.i][t.j+1] = 2;

	                q.add(new Pair(t.i, t.j+1));
	            }

	            if(isValid(t.i-1, t.j) && m[t.i-1][t.j] == 1) {

	                if(!flag) {
	                    cost++;
	                    flag = true;
	                }

	                m[t.i-1][t.j] = 2;

	                q.add(new Pair(t.i-1, t.j));
	            }

	            q.remove();
	        }

	        q.remove();

	        if(!q.isEmpty()) {
	            q.add(new Pair(-1, -1));
	        }
	    }

	    boolean rot = true;

	    for(int i = 0; i < r; i++) {
	        for(int j = 0; j < r; j++) {

	            if(m[i][j] == 1) {
	                rot = false;
	                break;
	            }
	        }
	    }
	}

	private static boolean isValid(int i, int j)
    {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }
}

class Pair {

    int i;
    int j;

    public Pair(int x, int y) {
        i = x;
        j = y;
    }
}

