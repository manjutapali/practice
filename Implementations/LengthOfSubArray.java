// Sum of lengths of non-overlapping sub-array, which has K as max element;

import java.util.Scanner;

public class LengthOfSubArray {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		while(T-->0) {
			
			int N = in.nextInt();

			int arr[] = new int[N];

			for(int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
			}

			int K = in.nextInt();

			System.out.println(GetSumLengthOfSubArray(arr, N, K));

		}
	}

	private static int GetSumLengthOfSubArray(int arr[], int N, int K) {

		int min = 0;
		int length = 0;
		for(int i = 0; i < N; i++) {

			if(arr[i] != K) {
				continue;
			}

			int j = i - 1;
			int k = i + 1;

			while(j >= min) {

				if(arr[j] < K) {
					j--;
				}
				else {
					break;
				}
			}

			while(k < N) {

				if(arr[k] < K) {
					k++;
				}
				else {
					break;
				}
			}

			length += (k - j - 1);
			min = k;
			i = k;

		}

		return length;
	}
}

