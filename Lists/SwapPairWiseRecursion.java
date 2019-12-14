public class SwapPairWiseRecursion {
	
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);

		swapPairsWise(l);
		l.display();
	}

	private static void swapPairsWise(LinkedList list) {
		swapPairsWise(list.head);
	}

	private static Node swapPairsWise(Node head) {
		if (head == null || head.next == null)
			return head;

		Node nextSwapNode = head.next.next;
		Node newHead = head.next;
		head.next.next = head;
		head.next = swapPairsWise(nextSwapNode);
		return newHead;
	}
}