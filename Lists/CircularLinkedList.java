class CircularLinkedList {

	private Node front;
	private Node rear;

	public void insert(int ele) {

		Node p = new Node(ele);

		if(front == null)
		{
			front = p;
			p.next = front;
			rear = front;

			return;
		}

		rear.next = p;
		rear = rear.next;
		rear.next = front;
	}

	public void print() {
		print(front);
	}

	private void print(Node front) {

		Node runnr = front;

		while(runnr.next != front) {

			System.out.println(runnr.data);
			runnr = runnr.next;
		}
		System.out.println(runnr.data);

	}

	public int removeLast() {
		
		return removeLast(front);
	}

	private int removeLast(Node front) {

		Node runnr = front;
		Node prev = null;

		while(runnr.next != front)
		{
			prev = runnr;
			runnr = runnr.next;
		}

		if(prev == null) {
			front = null;
			rear = null;
		}

		prev.next = front;

		return runnr.data;
	}
}