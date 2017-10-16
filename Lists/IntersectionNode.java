import java.util.HashSet;

public class IntersectionNode extends LinkedList
{
	public static void main(String[] args)
	{
		LinkedList l1 = new IntersectionNode();
		LinkedList l2 = new IntersectionNode();

		l1.add(10);
		l1.add(20);
		l1.add(30);
		l1.add(40);

		l2.add(30);
		l2.add(90);
		l2.head.next.next = l1.head.next.next;

		l1.display();
		l2.display();

		((IntersectionNode) l1).intersection(l2.head);		
	}

	public void intersection(Node listB)
	{
		Node listA = this.head;
		HashSet<Node> set = new HashSet<Node>();

		while(listA != null)
		{
			set.add(listA);
			listA = listA.next;
		}

		while(listB != null)
		{
			if(set.contains(listB))
			{
				System.out.println("intersection point = " + listB.data);
				return;
			}

			listB = listB.next;
		}
	}
}
