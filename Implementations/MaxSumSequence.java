// Find max sum sub-ssequence with no adjecent element
import java.util.Scanner;

public class MaxSumSequence {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int arr[] = new int[N];

		for(int i = 0; i < N; i++) {

			arr[i] = sc.nextInt();
		}

		int in = arr[0], ex = 0, temp;
		
		for(int i = 1; i < N; i++) {
			temp = in;

			if((arr[i] + ex) >= in)
				in = arr[i] + ex;

			ex = temp;
		}

		System.out.println(in);
	}
}