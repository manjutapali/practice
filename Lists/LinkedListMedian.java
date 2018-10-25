public class LinkedListMedian extends LinkedList
{
	public static void main(String[] args)
	{
		LinkedListMedian l = new LinkedListMedian();

		l.add(10);
        l.add(20);
        l.add(40);
        l.add(50);
        l.add(60);
        l.add(70);
        l.add(80);

        l.Median();
	}


	// Two pointers are created, one moves 2 step at a time, another moves one step
	// When fast pointer reaches, slower will be at the median.
	public void Median()
	{
		System.out.println("Median of the list is = " + Median(head));
	}

	private int Median(Node head)
	{
		Node fast = head;
		Node slow = head;

		while(fast != null && fast.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow.data;
	}
}