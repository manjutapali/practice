/*
	1. Keep one pointers for each list, compare the lists to check for the data.
	2. Sort the list, with merge sort and compare the list for data.
	3. Keep set, add a list, and check does set has the element 
*/

import java.util.HashSet;

public class UnionAndIntersection extends LinkedList
{
	public static void main(String[] args)
	{
		LinkedList l1 = new UnionAndIntersection();
		LinkedList l2 = new UnionAndIntersection();

		l1.add(10);
		l1.add(20);
		l1.add(30);
		l1.add(40);
		l1.add(50);
		l1.add(60);
		l1.add(70);

		l2.add(20);
		l2.add(40);
		l2.add(50);
		l2.add(70);
		l2.add(90);
		l2.add(100);

		l1.display();
		l2.display();

		LinkedList intr = ((UnionAndIntersection) l1).intersection(l2);
		LinkedList union = ((UnionAndIntersection) l1).union(l2);

		System.out.println("intersection:"); intr.display();
		System.out.println("Union:"); union.display();

	}

	public LinkedList intersection(LinkedList l2)
	{
		Node head1 = this.head;
		Node head2 = l2.head;

		LinkedList res = new LinkedList();

		HashSet<Integer> set = new HashSet<Integer>();

		while(head1 != null)
		{
			set.add(head1.data);
			head1 = head1.next;
		}

		while(head2 != null)
		{
			if(set.contains(head2.data))
			{
				res.add(head2.data);
			}

			head2 = head2.next;
		}

		return res;
	}

	public LinkedList union(LinkedList l2)
	{
		Node head1 = this.head;
		Node head2 = l2.head;

		LinkedList res = new LinkedList();

		HashSet<Integer> set = new HashSet<Integer>();

		while(head1 != null)
		{
			set.add(head1.data);
			res.add(head1.data);
			head1 = head1.next;
		}

		while(head2 != null)
		{
			if (!set.contains(head2.data))
			{
				res.add(head2.data);
			}
			
			head2 = head2.next;
		}

		return res;

	}

}