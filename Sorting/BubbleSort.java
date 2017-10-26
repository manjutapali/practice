/*
	* Bubble sort - Repeatedly compares two element adjecent to each other,
	  if greater, swaps the elements.
	* Best case - n(when already sorted), avg case - n^2, worst case - n^2
*/

public class BubbleSort
{
	public static void main(String[] args)
	{
		int arr[] = {7, 3, 9, 2, 4, 1};

		sort(arr);
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + "  ");
		}

		System.out.println();
	}

	private static void sort(int arr[])
	{
		for(int i = 0; i < arr.length - 1; i++)
		{
			for(int j = 0; j < arr.length - i - 1; j ++)
			{
				if(arr[j] > arr[j + 1])
				{
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;

				}
			}
		}
	}
}
