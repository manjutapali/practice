class Stack<E>
{
	private Node<E> top;
	private int SIZE;

	public void push(E data)
	{
		Node<E> newNode = new Node(data);
		newNode.next = top;
		top = newNode;

		SIZE++;
	}

	public E pop()
	{
		if(top != null)
		{
			E data = top.data;
			top = top.next;
			SIZE--;
			return data;
		}

		return null;
	}

	public E peek()
	{
		return top.data;
	}

	public int getSize()
	{
		return SIZE;
	}

	public void display()
	{
		Node<E> runnr = top;

		while(runnr != null)
		{
			System.out.println(runnr.data);
			runnr = runnr.next;
		}
	}

}