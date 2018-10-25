public class Driver
{
	public static void main(String[] args)
	{
		MinHeap h = new MinHeap(5);

		h.insert(14);
		h.insert(34);
		h.insert(5);
		h.insert(10);
		
		//System.out.println("Min = " + h.extractMin());

		h.insert(7);

		System.out.println("next min = " + h.getMin());

		h.display();
	}	
}