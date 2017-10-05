import java.util.Scanner;

public class IncreasingSubsequence
{
	public static void main(String[] args)
	{	
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String num[] = str.split("\\s");
		int arr[] = new int[num.length];

		for(int i = 0; i < num.length; i++)
		{
			try
			{
				arr[i] = Integer.parseInt(num[i]);
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid input, enter number with a space btwn");
			}
		}

		IncreasingSubsequence i = new IncreasingSubsequence();

		System.out.println("Longest increasing subsequence length = " + i.IncreasingSubsequenceLength(arr, arr.length));

	}

	public int IncreasingSubsequenceLength(int arr[], int len)
	{
		int l[] = new int[len];

		// Initializing the list.
		for(int i = 0; i < len; i++)
			l[i] = 1;

		for(int i = 1; i < len; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(arr[j] < arr[i])
					l[i] = Math.max(l[i], l[j] + 1);
			}
		}

		// Finding the max in l.
		int max = 0;
		for(int i = 0; i < len; i++)
		{
			if(max < l[i])
				max = l[i];
		}

		return max;
	}
}