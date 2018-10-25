// Given an array and a total, find a subset which has sum equal to total.

public class SubSetSum
{
	public static void main(String[] args)
	{
		int arr[] = {5, 9, 7, 11};
		int total = 12;

		System.out.println(IsSetExist(arr, total) ? "YES" : "NO");
	}


	public static boolean IsSetExist(int arr[], int total)
	{

		boolean t[][] = new boolean[arr.length + 1 ][total + 1];

		for(int i = 0; i <= arr.length; i++)
			t[i][0] = true;

		for(int i = 1; i <= arr.length; i++)
		{
			for(int j = 1; j <= total; j++)
			{

				if(j - arr[i - 1] >= 0)
				{
					t[i][j] = t[i-1][j] || t[i-1][j - arr[i-1]];
				}
				else
				{
					t[i][j] = t[i-1][j];
				}
			}
		}

		return t[arr.length][total];
	}
}