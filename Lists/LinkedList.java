pacakge list;

public class LinkedList{

    private Node head = null;

    public void insert(int ele){
      head = insert(ele, head);
    }

    private Node insert(int ele, Node head){
        Node p = new Node(ele);
        if(head == null){
          head = p;
          return head;
        }

        Node runnr = head;
        while(runnr.next != null){
          runnr = runnr.next;
        }
        runnr.next = p;

        return head;
    }

    public void display(){
        display(head);
    }

    private void display(Node head){
        Node runnr = head;

        while(runnr != null){
            System.out.println(runnr.data);
        }
    }

}
