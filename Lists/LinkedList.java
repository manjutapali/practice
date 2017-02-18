class Node
{
    int data;
    Node next;

    public Node(int ele)
    {
        data = ele;
        next = null;
    }
}

class List{

    private Node head = null;

    public void insert(int ele)
    {
      head = insert(ele, head);
    }

    private Node insert(int ele, Node head)
    {
        Node p = new Node(ele);
        if(head == null)
        {
          head = p;
          return head;
        }

        Node runnr = head;
        while(runnr.next != null)
        {
          runnr = runnr.next;
        }
        runnr.next = p;

        return head;
    }

    public void display()
    {
        display(head);
    }

    private void display(Node head)
    {
        Node runnr = head;

        while(runnr != null)
        {
            System.out.println(runnr.data);
            runnr = runnr.next;
        }
    }

    public void reverse()
    {
        System.out.println("Reversing linked list...");
        head = reverseRec(head, null);
    }

    private Node reverse(Node head)
    {
        Node prev = null;
        Node next = null;
        Node curr = head;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private Node reverseRec(Node curr, Node prev)
    {
        if(curr == null)
            return curr;

        if(curr.next == null)
        {
            head = curr;
            curr.next = prev;
            return null;
        }

        Node next = curr.next;
        curr.next = prev;

        reverseRec(next, curr);
        return head;
    }

}

public class LinkedList{

    public static void main(String[] args)
    {
        List l = new List();

        l.insert(10);
        l.insert(20);
        l.insert(40);
        l.insert(50);
        l.insert(60);
        l.insert(70);
        l.display();
        l.reverse();
        l.display();
    }
}
