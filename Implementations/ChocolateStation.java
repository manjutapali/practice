// Chocolate station

import java.util.Scanner;

public class ChocolateStation {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		while(T-->0) {

			int N = in.nextInt();

			int s[] = new int[N];

			for(int i = 0; i < N; i++) {
				s[i] = in.nextInt();
			}

			int c = in.nextInt();

			System.out.println(GetChocoCost(s, N, c));
		}
	}

	private static int GetChocoCost(int s[], int N, int c) {

		int choco_count = s[0];
		int curr = 0;

		for(int i = 1; i < N; i++) {

			int diff = s[i-1] - s[i];

			if((curr + diff) < 0) {
				choco_count += -(curr + diff);
				curr = 0;
			}
			else {

				curr += s[i-1] - s[i];
			}

		}

		return choco_count * c;
	}
}