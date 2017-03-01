/*
Given a N X N matrix (M) filled with 1 , 0 , 2 , 3 . Your task is to find whether there is a path
possible from source to destination, while traversing through blank cells only. You can traverse
up, down, right and left.

A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Blank Wall.

*/

import java.util.*;

class GFG
{
	public static void main (String[] args)
  {
      Scanner in = new Scanner(System.in);

      int N = in.nextInt();
      int arr[][] = new int[N][N];
        //System.out.println("len = " + N);
      int stx = 0;
      int sty = 0;
      for(int a = 0; a < N; a++)
      {
          for(int b = 0; b < N; b++)
              {
                  arr[a][b] = in.nextInt();
                  if(arr[a][b] == 1)
                  {
                      stx = a;
                      sty = b;
                  }
            }
        }

        System.out.println(checkPathExists(arr, N, stx, sty));
		}

	static int checkPathExists(int arr[][], int N, int stx, int sty)
	{

	    Queue<Pair> queue = new LinkedList<Pair>();
	    Pair p = new Pair(stx, sty);

	    queue.add(p);

	    while(queue.size() != 0)
	    {
	        Pair q = queue.poll();
	        int i = q.x;
	        int j = q.y;

	        if(arr[i][j] == 2)
	            return 1;

	        if(i+1 < N && arr[i+1][j] != 0)
	        {
	            queue.add(new Pair(i+1,j));
	        }

	        if(j+1 < N && arr[i][j+1] != 0)
	        {
	            queue.add(new Pair(i, j+1));
	        }

	        if(i-1 >= 0 && arr[i-1][j] != 0)
	        {
	            queue.add(new Pair(i-1,j));
	        }

	        if(j-1 >= 0 && arr[i][j-1] != 0)
	        {
	            queue.add(new Pair(i, j-1));
	        }
	    }

	    return 0;
	}
}

class Pair
{
    int x;
    int y;

    public Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
