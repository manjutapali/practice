/*
	* Compare two list represented as strings.
	* http://www.geeksforgeeks.org/compare-two-strings-represented-as-linked-lists/.
*/

public class CompareStrings extends GenericLinkedList
{
	public static void main(String[] args)
	{
		GenericLinkedList<Character> l1 = new CompareStrings();
		GenericLinkedList<Character> l2 = new CompareStrings();

		l1.add('b');
		l1.add('a');
		l1.add('g');
		l1.add('x');

		l2.add('b');
		l2.add('a');
		l2.add('g');
		l2.add('s');

		l1.display();
		l2.display();

		System.out.println("Compare result = " + ((CompareStrings) l1).comapre(l2));
	}

	public int comapre(GenericLinkedList l2)
	{
		GenericNode h1 = this.head;
		GenericNode h2 = l2.head;
		int count = 0;
		while(h1 != null && h2 != null)
		{
			if(h2.data == h1.data)
			{
				h1 = h1.next;
				h2 = h2.next;
				continue;
			}

			if((char)h2.data > (char)h1.data)
			{
				count--;
			}
			else
			{
				count++;
			}

			h1 = h1.next;
			h2 = h2.next;
		}

		while(h2 != null)
		{
			count--;
			h2 = h2.next;
		}

		while(h1 != null)
		{
			count++;
			h1 = h1.next;
		}

		return count;
	}
}