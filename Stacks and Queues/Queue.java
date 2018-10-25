class Queue<E>
{
	private Node<E> first, last;
	private int SIZE;

	public void enqueue(E data)
	{
		if(first == null)
		{
			last = new Node<E>(data);
			first = last;
		}
		else
		{
			last.next = new Node<E>(data);
			last = last.next;
		}

		SIZE++;
	}

	public E dequeue()
	{
		if(first != null)
		{
			E data = first.data;
			first = first.next;

			if(first == null)
				last = null;

			SIZE--;

			return data;
		}

		return null;
	}

	public int size()
	{
		return SIZE;
	}

	public void display()
	{
		Node<E> runnr = first;

		while(runnr != null)
		{
			System.out.println(runnr.data);
			runnr = runnr.next;
		}
	}
}