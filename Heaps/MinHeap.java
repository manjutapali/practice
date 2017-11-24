class MinHeap
{
    private int HEAP_SIZE;
    private int heap[];
    private int REAR;
    private int CURR;
    
    public MinHeap(int k)
    {
        HEAP_SIZE = k;
        heap = new int[k+1];
    }
    
    public int getLeft(int i)
    {
        return 2*i;
    }
    
    public int getRight(int i)
    {
        return 2*i + 1;
    }
    
    public int getParent(int i)
    {
        return (i+1)/2;
    }
    
    public boolean isFull()
    {
        if(HEAP_SIZE == CURR)
            return true;
        
        return false;
    }
    
    public int getMin()
    {
        if(CURR != 0)
            return heap[1];
        
        return -1;    
    }
    
    public void insert(int ele)
    {
        if(CURR == HEAP_SIZE)
        {
            return;
        }

        heap[++CURR] = ele;
        REAR = CURR;
        int i = CURR;

        while(heap[i] < heap[getParent(i)])
        {
            
            swap(i, getParent(i));
            i = getParent(i);
        }

    }
    
    public void BubbleUp(int curr)
    {
        int i = curr;
        
        while(i > 1)
        {
            int par = getParent(i);
            
            if(heap[par] > heap[i])
            {
                swap(i, par);
                i = par;
                continue;
            }
            
            return;
        }
    }
    
    public int extractMin()
    {
        int min = heap[1];
        heap[1] = heap[CURR--];
        
        MinHeapify(1);
        
        return min;
    }
    
    public void MinHeapify(int curr)
    {
        if(!isLeaf(curr))
        {
            int par = curr;
            int left = getLeft(curr);
            int right = getRight(curr);
            
            if(heap[left] < heap[par] || heap[right] < heap[par])
            {
                if(heap[left] < heap[right])
                {
                    swap(left, curr);
                    MinHeapify(left);
                }
                else
                {
                    swap(right, curr);
                    MinHeapify(right);
                }
            }
        }
    }
    
    public boolean isLeaf(int i)
    {
        if(i >= (HEAP_SIZE/2) && i <= HEAP_SIZE)
            return true;
        
        return false;
    }
    
    public void swap(int i1, int i2)
    {
        int temp = heap[i1];
        heap[i1] = heap[i2];
        heap[i2] = temp;
    }
    
    public void display()
    {
        for(int i = 0; i < HEAP_SIZE; i++)
        {
            System.out.print(heap[i] + ", ");
        }
        System.out.println();
    }

    public int[] getHeap()
    {
        return heap;
    }
}