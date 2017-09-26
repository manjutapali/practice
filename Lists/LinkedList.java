class LinkedList
{
    protected Node head = null;

    public void add(int data)
    {
        head = add(head, data);
    }

    private Node add(Node head, int data)
    {
        if(head == null)
        {
            return new Node(data);
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

    private Node display(Node head, StringBuffer contents)
    {
        if(head == null)
          return head;

         contents.append((head.data + ", "));
        return display(head.next, contents);
    }

    public void reverse()
    {
        head = reverse(head, null);
    }

    private Node reverse(Node curr, Node prev)
    {
        if(curr.next == null)
        {
            head = curr;
            curr.next = prev;

            return null;
        }

        Node next = curr.next;
        curr.next = prev;

        reverse(next, curr);

        return head;
    }
}
