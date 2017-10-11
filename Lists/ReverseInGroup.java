public class ReverseInGroup extends LinkedList
{
	public static void main(String[] args)
	{
		ReverseInGroup r = new ReverseInGroup();
		r.add(10);
		r.add(20);
		r.add(30);
		r.add(40);
		r.add(50);
		r.add(60);
		r.add(70);
		r.add(80);
		r.add(90);

		r.display();

		int rev_k = 3;
		r.reverse(rev_k);

		r.display();

	}

	public void reverse(int rev_k)
	{
		head = reverse(head, rev_k);
	}

	private Node reverse(Node head, int k)
	{
		Node curr = head, prev = null, next = null;
		int count = 1;

		while(count <= k && curr != null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		if(next != null)
			head.next = reverse(next, k);

		return prev;

	}
}