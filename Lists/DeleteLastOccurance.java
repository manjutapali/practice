public class DeleteLastOccurance extends LinkedList
{
	public static void main(String[] args)
	{
		LinkedList d = new DeleteLastOccurance(); 

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
		d.add(60);
		d.add(110);

		d.display();

		((DeleteLastOccurance) d).Delete(d.head, 60);

		d.display();
	}

	public void Delete(Node head, int key)
	{
		Node runnr = head;
		Node node = null;

		while(runnr != null)
		{
			if(runnr.data == key)
				node = runnr;

			runnr = runnr.next;
		}

		if(node != null)
		{
			node.data = node.next.data;
			node.next = node.next.next;
		}
	}
}

