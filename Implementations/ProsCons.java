// https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/practice-problems/algorithm/pro-and-con-list/

import java.util.Scanner;
import java.util.Arrays;

public class ProsCons
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		for(int i = 0; i < T; i++)
		{
			int n = in.nextInt();

			long arr[] = new long[n];
			long sad = 0;
			for(int j = 0; j < n; j++)
			{
				long h = in.nextInt();
				long a = in.nextInt();

				arr[i] = h + a;
				sad += a;
			}

			Arrays.sort(arr);

			System.out.println(arr[n-1] + arr[n-2] - sad);
		}
	}
}