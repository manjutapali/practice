public class RotateLinkedList extends LinkedList
{
	
	public static void main(String[] args)
	{
		RotateLinkedList l = new RotateLinkedList();
		l.add(10);
		l.add(20);
		l.add(30);	;
		l.add(40);
		l.add(50);
		l.add(60);

		int k = 4;

		l.display();
		l.RotateList(k);
		l.display();

	}

	public void RotateList(int k)
	{
		head = RotateList(head, k);
	}

	public Node RotateList(Node head, int k)
	{
		Node runnr = head;
		Node prev = null;
		int count = 0;
		
		while(runnr != null && count <= k - 1)
		{
			prev = runnr;
			runnr = runnr.next;
			count++;
		}
		
		// Return head if k value is more than length of list.
		if(runnr == null)
			return head;

		prev.next = null;
		Node curr = runnr;
		while(runnr.next != null)
			runnr = runnr.next;

		runnr.next = head;
		head = curr;

		return head;
	}

}