class GenericNode<E>
{
	E data;
	GenericNode<E> next;

	public GenericNode(E data)
	{
		this.data = data;
		this.next = null;
	}

	public GenericNode(){};
}