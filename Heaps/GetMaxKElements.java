import java.util.*;
import java.util.Arrays;
import java.lang.*;
import java.io.*;

class GetMaxKElements {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for(int i = 0; i < T; i++)
		{
		    int N = in.nextInt();
		    int k = in.nextInt();
		    
		    MinHeap h = new MinHeap(k);
		    
		    for(int j = 0; j < N; j++)
		    {
		        int t = in.nextInt();
		        if(!h.isFull())
		        {
		            h.insert(t);
		            
		        }
		        //h.display();
		        if(t > h.getMin())
		        {
		            h.extractMin();
		            h.insert(t);
		        }
		    }
		    
            int heap[] = h.getHeap();
            Arrays.sort(heap);

            for(int l = heap.length - 1; l > 0; l--)
            {
                System.out.print(heap[l] + " ");
            }

            System.out.println();
		   
		}
	}
}
