class GenericLinkedList<E>
{
	protected GenericNode<E> head = null;

    public void add(E data)
    {
        head = add(head, data);
    }

    private GenericNode<E> add(GenericNode<E> head, E data)
    {
        if(head == null)
        {
            return new GenericNode<E>(data);
        }
        else
        {
            head.next = add(head.next, data);
            return head;
        }
    }

    public void display()
    {
        StringBuffer contents = new StringBuffer("[");
        display(head, contents);
        System.out.println(contents + "]");
    }

    private GenericNode<E> display(GenericNode<E> head, StringBuffer contents)
    {
        if(head == null)
          return head;

         contents.append((head.data + ", "));
        return display(head.next, contents);
    }

    public void reverse()
    {
        //head = reverse(head, null);

        head = reverseItr(head);
    }

    private GenericNode<E> reverse(GenericNode<E> curr, GenericNode<E> prev)
    {
        if(curr.next == null)
        {
            head = curr;
            curr.next = prev;

            return null;
        }

       	GenericNode<E> next = curr.next;
        curr.next = prev;

        reverse(next, curr);

        return head;
    }

    private GenericNode<E> reverseItr(GenericNode<E> curr)
    {   
        GenericNode<E> prev = null;
        GenericNode<E> next = null;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}