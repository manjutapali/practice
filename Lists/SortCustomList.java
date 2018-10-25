/*
	* Given linked list of 0's, 1's and 2's. Sort the linked list.
	soln : count the number of 0, 1, 2 and add those many in the list.
*/

public class SortCustomList extends LinkedList
{
	public static void main(String[] args)
	{
		LinkedList l1 = new SortCustomList();

		l1.add(2);
		l1.add(0);	;
		l1.add(2);
		l1.add(1);
		l1.add(0);
		l1.add(0);
		l1.add(1);

		l1.display();
		((SortCustomList)l1).sort();
		l1.display();
	}

	public void sort()
	{
		int count[] = new int[3];

		Node runnr = this.head;

		while(runnr != null)
		{
			count[runnr.data]++;
			runnr = runnr.next;
		}
		
		runnr = this.head;
		int i = 0;

		while(runnr != null)
		{
			if(count[i] > 0)
			{
				runnr.data = i;
				count[i]--;
				runnr = runnr.next;
			}
			else
			{
				i++;
			}
		}
	}
}
