/*
	* Check if reversing sub-array makes sorted array

	* http://www.geeksforgeeks.org/check-reversing-sub-array-make-array-sorted/
*/

public class ReverseSubArray
{
	public static void main(String[] args)
	{
		int arr[] = {1, 2, 5, 6, 9, 6, 8};

		System.out.println(CheckReverseSubArraySorted(arr, arr.length) ? "YES" : "NO");	
	}

	private static boolean CheckReverseSubArraySorted(int arr[], int n)
	{
		// Sorting the array
		int copy[] = new int[n];
		System.arraycopy(arr, 0, copy, 0, n);

		MergeSort.sort(copy, 0, copy.length - 1);

		int st = -1, end = -1;
		boolean first_idx = false;
		for(int i = 0; i < n; i++)
		{

			if(arr[i] != copy[i] && !first_idx)
			{
				first_idx = true;
				st = i;
			}

			if(first_idx && arr[i] != copy[i])
			{
				end = i;
			}
		}

		if(st == -1 && end == -1)
			return true;

		for(int i = st; i <= end - 1; i++)
		{
			if(arr[i] < arr[i + 1])
				return false;
		}

		return true; 
	}

}