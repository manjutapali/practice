public class MergeKSortedLinkedList
{
	public static void main(String[] args)
	{
		int k = 4;

		LinkedList lists[] = new LinkedList[k];

		for(int i = 0; i < 4; i++)
		{	lists[i] = new LinkedList();
			for(int j = 0; j < 5; j++)
				lists[i].add(j);
		}

		 LinkedList l = MergeLists(lists, k - 1);

		l.display();
	}

	public static LinkedList MergeLists(LinkedList lists[], int k)
	{	
		

		while(k != 0)
		{
			int i = 0, j = k;
			while(i < j)
			{
				lists[i] = Merge(lists[i], lists[j]);
				
				i++; j--;

				if(i >= j)
					k = j;
			}
		}

		return lists[0];
	}

	public static LinkedList Merge(LinkedList l1, LinkedList l2)
	{
		
		Node runnr1 = l1.head;
		Node runnr2 = l2.head;

		LinkedList result = new LinkedList();
		result.head = new Node(0);
		Node res = result.head;
		while(runnr1 != null && runnr2 != null)
		{
			
			if(runnr1.data <= runnr2.data)
			{
				res.next = runnr1;
				runnr1 = runnr1.next;
			}
			else
			{
				res.next = runnr2;
				runnr2 = runnr2.next;
			}

			res = res.next;

		}

		if(runnr1 != null)
			res.next = runnr1;

		if(runnr2 != null)
			res.next = runnr2;

		result.head = result.head.next;

		return result;
	}
}