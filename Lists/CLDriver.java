public class CLDriver {

	public static void main(String[] args) {
		
		CircularLinkedList l = new CircularLinkedList();

		l.insert(10);
		l.insert(20);
		l.insert(30);
		l.insert(40);
		l.print();
		l.removeLast();
		l.print();
	}
}