import java.util.Scanner;
import java.util.Arrays;

public class MaximumSumSubSequence
{
	public static void main(String[] args)
	{
			Scanner in = new Scanner(System.in);

			// Takes array as string
			String input = in.nextLine();

			String temp[] = input.split("\\s");
			int arr[] = new int[temp.length];
			for(int i = 0; i < temp.length; i++){
				if(temp[i] != " ")
					arr[i] = Integer.parseInt(temp[i]);

			}

			MaximumSumSubSequence m = new MaximumSumSubSequence();

			m.PrintMaxSumSubSequence(arr, arr.length);
	}

	public void PrintMaxSumSubSequence(int arr[], int N)
	{
		int l[] = new int[N];
		int seq[] = new int[N];

		for(int i = 0; i < N; i++)
			l[i] = arr[i];

		for(int i = 1; i < N; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(arr[j] < arr[i])
				{
					int temp = l[j] + arr[i];
					if(l[i] < temp){
						seq[i] = j;
						l[i] = temp;
					}
				}
			}
		}

		int max = l[0];
		int k = -1;
		for(int i = 1; i < N; i++){
			if(max < arr[i]){
				max = arr[i];
				k = i;
			}
		}

		//System.out.println(Arrays.toString(l));
		System.out.println("Subsequence sum = " + max);
		System.out.println("The sub sequence is :");
		//System.out.println(Arrays.toString(seq));
		while(k >= 0)
		{
			System.out.print(arr[k] + ",");
			if(k == 0)
				break;
			k = seq[k];
		}
		System.out.println();
	}

}