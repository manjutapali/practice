/*
	* Inserting curr element in sorted sequence.
	* Best - n, avg - n^2, worst - n^2.
*/

public class InsertionSort
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
		for(int i = 1; i < n; i++)
		{
			int key = arr[i];
			int j = i - 1;
			while(j >=0 && arr[j] > key)
			{
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
}