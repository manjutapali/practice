// Delete N nodes after iterating over M nodes in linked list

public class DeleteNAfterM extends LinkedList
{
	public static void main(String[] args)
	{
		DeleteNAfterM d = new DeleteNAfterM();

		d.add(10);
		d.add(20);
		d.add(30);
		d.add(40);
		d.add(50);
		d.add(60);
		d.add(70);
		d.add(80);
		d.add(90);
		d.add(100);
		d.add(110);

		int m = 3;
		int n = 2;

		d.display();
		d.Delete(m, n);
		d.display();
	}


	public void Delete(int m, int n)
	{
		Delete(head, m, n);
	}

	private void Delete(Node head, int m, int n)
	{
		Node curr = head;
		int c1 = 1;
		int c2 = 0;

		while(curr != null)
		{
			if(c1 == m)
			{
				Node runnr = curr;
				while (runnr != null && c2 <= n)
				{
					runnr = runnr.next;
					c2++;
				}
				curr.next = runnr;
				c2 = 0;
				c1 = 0;
			}
			else{
				curr = curr.next;
				c1++;
			}
		}
	}

}