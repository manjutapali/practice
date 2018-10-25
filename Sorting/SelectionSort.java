/*
	* Finds min element in the next subarray and add at the curr location.
	* Best - n^2, avg - n ^2, worst n^2
*/

public class SelectionSort
{
	public static void main(String[] args)
	{
		int arr[] = {5,3,8,2,1,4};

		sort(arr, arr.length);
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + "  ");
		}

		System.out.println();
	}

	private static void sort(int arr[], int n)
	{
		for(int i = 0; i < n - 1; i++)
		{	
			int min = i;
			for(int j = i + 1; j < n; j++)
			{
				if(arr[min] > arr[j])
					min = j;
			}

			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
}