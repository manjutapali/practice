public class Driver
{
	public static void main(String[] args)
	{
		Stack<Integer> s = new Stack<Integer>();

		Queue<Integer> q = new Queue<Integer>();

		System.out.println("------------------stack--------------------");
		s.push(21);
		s.push(24);
		s.push(11);
		s.display();
		s.pop();
		s.display();

		System.out.println("-------------------Queue-------------------");
		q.enqueue(12);
		q.enqueue(32);
		q.enqueue(45);
		q.display();
		q.dequeue();
		q.display();	
	}
}