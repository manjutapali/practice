// Check if given linked list is palindrome

public class PalindromeList extends LinkedList
{
	public static void main(String[] args)
	{
		
		LinkedList l = new PalindromeList();

		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.add(40);
		l.add(30);
		l.add(20);
		l.add(10);
		l.display();

		System.out.println("Is palindrome : " + ((PalindromeList)l).isPalindrome());
		l.display();	
	}

	public boolean isPalindrome()
	{
		Node head = this.head;

		return isPalindrome(head);
	}

	private boolean isPalindrome(Node head)
	{
		Node runnr1 = head;
		Node runnr2 = head;
		Node prev = null;
		while(runnr1 != null && runnr2 != null && runnr2.next != null)
		{
			prev = runnr1;
			runnr1 = runnr1.next;
			runnr2 = runnr2.next.next;
		}

		// runnr1 ptr is at mid, reverse the linked list after that.
		// if runnr2 is null, then there are even number of nodes

		if(runnr2 == null)
		{
			prev.next = reverse(runnr1);
		}
		else
		{
			prev = prev.next;
			prev.next = reverse(runnr1.next);
		}
		runnr1 = prev.next;
		runnr2 = head;

		while(runnr1 != null && runnr2 != null)
		{
			if(runnr1.data != runnr2.data)
				return false;

			runnr1 = runnr1.next;
			runnr2 = runnr2.next;
		}

		return true;
	}

}
