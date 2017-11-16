/*
    Considering index starts at 1;
    leftChild - 2 * i;
    rightChild - 2 * i + 1;
    parent - i / 2;

*/

import java.util.Arrays;
public class MaxHeap
{
    public static void main(String[] args)
    {
        Heap h = new Heap(10);
        h.insert(16);
        h.insert(4);
        h.insert(10);
        h.insert(14);
        h.insert(7);
        h.insert(9);
        h.insert(3);
        h.insert(2);
        h.insert(8);
        h.insert(1);

        int max = h.getMax();
        System.out.println("Max key = " + max);
        h.DisplayHeap();

        max = h.extractMax();
        System.out.println("Max key del = " + max);
        h.Display();

        max = h.extractMax();
        System.out.println("Max key del = " + max);
        h.Display();
    }
}

class Heap
{
    private int HEAP_SIZE;
    private int heap[];
    private int curr = 0;
    private int REAR;

    public Heap(int size)
    {
        this.HEAP_SIZE = size;

    }

    public int getLeftChild(int i)
    {
        return 2*i;
    }

    public int getRightChild(int i)
    {
        return 2*i+1;
    }

    public int getParent(int i)
    {
        return i/2;
    }

    public int getMax()
    {
        // Max key always at the root;
        return heap[1];
    }

    public void insert(int ele)
    {
        if(heap == null)
        {
            heap = new int[HEAP_SIZE + 1];
            heap[++curr] = ele;
            return;
        }
        else if(curr == HEAP_SIZE)
        {
            System.out.println("Array is full");
            return;
        }

        heap[++curr] = ele;
        REAR = curr;
        BubbleUp(curr);
    }

    private void BubbleUp(int curr)
    {
        // check if parent lesser than child, if it is swap the parent with child;
        // Bubble up operation;

        int i = curr;
        while(i > 1)
        {
            int par = getParent(i);

            if(heap[par] < heap[i])
            {
                swap(i, par);
                i = par;
                continue;
            }
            
            return;
        }
    }

    public void DisplayHeap()
    {
        System.out.println(Arrays.toString(heap));
    }

    public int extractMax()
    {
        int max = heap[1];
        heap[1] = heap[REAR--];
        MaxHeapify(1);

        return max;
    }

    private void MaxHeapify(int curr)
    {
        if(!isLeaf(curr))
        {
            
            int par = curr;
            int left = getLeftChild(curr);
            int right = getRightChild(curr);
            if(heap[par] < heap[left]  || heap[par] < heap[right])
            {
                if(heap[left] > heap[right])
                {
                    swap(curr, left);
                    MaxHeapify(left);
                }
                else
                {
                    swap(curr, right);
                    MaxHeapify(right);
                }
            }
        }
    }

    private boolean isLeaf(int curr)
    {
        if(curr >= (HEAP_SIZE/2) && curr <= HEAP_SIZE)
        {
            return true;
        }

        return false;
    }

    private void swap(int pos1, int pos2)
    {
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    public void Display()
    {
        System.out.print("[");
        for(int i = 1; i <= REAR; i++)
        {
            System.out.print(heap[i]+", ");
        }
        System.out.println("]");
    }

}
