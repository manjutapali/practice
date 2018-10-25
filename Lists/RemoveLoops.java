public class RemoveLoops extends LinkedList
{

	public static void main(String[] args)
	{
		LinkedList l = new RemoveLoops();

		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.add(60);

		l.head.next.next.next.next = l.head.next;
		((RemoveLoops)l).RemoveLoop();
		l.display();

	}

	public void RemoveLoop()
	{
		DetectLoopAndRemove(head);
	}

	private void DetectLoopAndRemove(Node head)
	{
		Node slow = head;
		Node fast = head;

		while(slow != null && fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;

			if(slow == fast)
			{
				
				System.out.println("There is loop in the list, removing..." + slow.data);
				removeLoops(slow);
				return;
			}
		}

		System.out.println("There are no loops in the list");
	}

	/*
	private int GetNumNodeInLoop(Node curr)
	{
		Node runnr = curr.next;
		int count = 1;

		while(runnr != curr)
		{
			System.out.println(count);
			runnr = runnr.next;
			count++;
		}

		return count;
	}
	*/

	private void removeLoops(Node st)
	{

		Node runnr1 = head;
		Node runnr2;
		Node prev;
		while(runnr1 != null)
		{
			runnr2 = st.next;
			prev = st;
			while(runnr2 != st)
			{
				if(runnr2 == runnr1)
				{
					prev.next = null;
					return;
				}
				prev = runnr2;
				runnr2 = runnr2.next;
			}

			runnr1 = runnr1.next;

		}
	}       
}