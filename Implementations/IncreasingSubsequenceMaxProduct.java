import java.util.Scanner;
import java.util.Arrays;

public class IncreasingSubsequenceMaxProduct
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		IncreasingSubsequenceMaxProduct m = new IncreasingSubsequenceMaxProduct();

		int N = in.nextInt();
		int arr[] = new int[N];
		for(int i = 0; i < N ; i++)
		{
			arr[i] = in.nextInt();
		}
		int k = in.nextInt();
		
		System.out.println(m.getMaxProductSubsequence(arr, N, k));		
	}

	public int getMaxProductSubsequence(int arr[], int N, int k)
	{
		// Get MAX LEFT SIDE
		int L[] = getLeftMax(arr, N);
		// Get MAX RIGHT SIDE
		int R[] = getRightMax(arr, N);
		System.out.println(Arrays.toString(L));
		System.out.println(Arrays.toString(R));
		int max = Integer.MIN_VALUE;

		for(int i = 0; i < N; i++)
		{
			if((L[i] * arr[i] * R[i]) > max)
				max = L[i] * arr[i] * R[i];
		}

		return max;
	}

	public int[] getLeftMax(int arr[], int N)
	{
		int max = arr[0];
		int res[] = new int[N];
		res[0] = max;
		for(int i = 1; i < N; i++)
		{
			if(max < arr[i])
				max = arr[i];

			arr[i] = max;
		}

		return res;
	}

	public int[] getRightMax(int arr[], int N)
	{
		int max = arr[N - 1];
		int res[] = new int[N];
		res[N - 1] = max;
		for(int i = N - 2; i >= 0; i--)
		{
			if(max < arr[i])
				max = arr[i];

			if(max > arr[i])
				res[i] = max;
			else
				res[i] = 0;
		}

		return res;
	}
}
