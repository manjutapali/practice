/*

	* Check if next node has same values, if they have the same

*/

public class RemoveDuplicatesInSortedList extends LinkedList
{
	public static void main(String[] args)
	{
		RemoveDuplicatesInSortedList l = new RemoveDuplicatesInSortedList();

		l.add(10);
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(30);
		l.add(40);

		l.display();
		l.RemoveDuplicates();
		l.display();	
	}

	public void RemoveDuplicates()
	{
		RemoveDuplicates(head);
	}

	private void RemoveDuplicates(Node head)
	{
		Node curr1 = head;
		Node curr2;

		if(head == null)
			return;

		while(curr1.next != null)
		{
			if(curr1.data == curr1.next.data)
			{
				curr2 = curr1.next.next;
				curr1.next = null;
				curr1.next = curr2;
			}
			else
			{
				curr1 = curr1.next;
			}
		}
	}
}