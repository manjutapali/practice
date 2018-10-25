// http://practice.geeksforgeeks.org/problems/reorder-list/1

public class ReorderList extends LinkedList
{
	public static void main(String[] args)
	{
		LinkedList l = new ReorderList();

		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.add(60);
		l.add(70);
		l.add(80);
		l.add(90);
		l.display();
		LinkedList l1 = new LinkedList();

		l1.head = ((ReorderList)l).reorder(l.head);
		l.display();
	}

	public Node reorder(Node head)
	{
		int n = ListLen(head);
		Node a[] = new Node[n];
		Node runnr = head;
		int i = 0;
		while(runnr != null)
		{
			a[i] = runnr;
			runnr = runnr.next;
			i++;
		}

		int last = n-1, first = 0;
		runnr = head;
		Node next = null;
		int count = 0;
		while(last > first)
		{
			next = runnr.next;
			runnr.next = a[last];
			runnr = runnr.next;
			runnr.next = next;
			runnr = runnr.next;
			last--;
			first++;
		}

		runnr.next = null;

		return head;
	}

	public int ListLen(Node head)
	{
		Node runnr = head;
		int count = 0;
		while(runnr != null)
		{
			count++;
			runnr = runnr.next;
		}

		return count;
	}

}