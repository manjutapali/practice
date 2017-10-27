/*
	* Find median in given two sorted arrays of size n each.

	approch - Find elements at position n, n - 1 while merging two arrays.
*/

public class FindMedian
{
	public static void main(String[] args)
	{
		int arr1[] = {1, 2, 3, 4, 5};
		int arr2[] = {6, 7, 8, 9, 10};

		int median = GetMedian(arr1, arr2, arr1.length - 1);

		System.out.println("Median is = " + median);
	}

	public static int GetMedian(int arr1[], int arr2[], int n)
	{
		int i = 0, j = 0;
		// two medians
		double m1 = -1.0,m2 = -1.0;

		for(int k = 0; k <= n; k++)
		{
			if(i == n)
			{
				m1 = arr1[n];
				m2 = arr2[0];
				break;
			}
			else if(j == n)
			{
				m1 = arr2[n];
				m2 = arr1[0];
				break;
			}

			if(arr1[i] < arr2[j])
			{
				m1 = m2;
				m2 = arr1[i];
				i++;
			}
			else
			{
				m1 = m2;
				m2 = arr2[j];
				j++;
			}
		}
		System.out.println("m1 = " + m1 + " m2 = " + m2);
		return (int)Math.floor((m1 + m2) / 2);
	}
}