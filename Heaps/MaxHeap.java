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

        //TODO - MaxKeyExtcraction() - deletes the max key;
    }
}

class Heap
{
    private int HEAP_SIZE;
    private int heap[];
    private int curr = 0;
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
        MaxHeapify(curr);
    }

    private void MaxHeapify(int curr)
    {
        // check if parent lesser than child, if it is swap the parent with child;
        // Bubble up operation;
        
        int i = curr;
        while(i > 0)
        {
            int par = getParent(i);

            if(heap[par] < heap[curr])
            {
                int temp = heap[par];
                heap[par] = heap[curr];
                heap[curr] = temp;
            }
            else
            {
                return;
            }

            i = par;
        }
    }

    public void DisplayHeap()
    {
        System.out.println(Arrays.toString(heap));
    }

}
