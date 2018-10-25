public class LastNthNode extends LinkedList
{
	public static void main(String[] args)
	{
		LastNthNode l = new LastNthNode();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.add(60);
		l.add(70);
		l.add(80);

		int k = 3;

		l.display();
		int data = l.GetNthLastNode(k);

		System.out.println(data);
	}

	public int GetNthLastNode(int k)
	{
		return GetNthLastNode(head, k);
	}

	private int GetNthLastNode(Node head, int k)
	{
		Node curr1 = head;
		Node curr2 = head;
		int count = 1;
		if(curr1 != null)
		{
			while(count <= k)
			{
				if(curr1 == null)
				{
					System.out.println("K val is more than length of the list");
					return -1;
				}

				curr1 = curr1.next;
				count++;
			}

			while(curr1 != null)
			{
				curr1 = curr1.next;
				curr2 = curr2.next;
			}

			return curr2.data;
		}
		else
		{
			System.out.println("No list head");
			return -1;
		}


	}
}