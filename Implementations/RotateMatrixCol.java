// Rotate the matrix by column wise by K times
import java.util.Scanner;

public class RotateMatrixCol {

	public static void main(String[] args) {
			
			Scanner in = new Scanner(System.in);

			int T = in.nextInt();

			while(T > 0) {

				int M = in.nextInt();
				int N = in.nextInt();
				int K = in.nextInt();

				int m[][] = new int[M][N];

				for(int i = 0; i < M; i++) {

					for(int j = 0; j < N; j++) {

						m[i][j] = in.nextInt();
					}
				}

				RotateMatrix(m, M, N, K);
				PrintMatrix(m, M, N);
				T--;
			}
	}

	private static void RotateMatrix(int m[][], int M, int N, int K) {

		int t = K % N;

		for(int i = 0; i < M; i++) {

			for(int j = 0; j < t; j++) {

				int temp = m[i][0];
				for(int k = 1; k < N; k++) {
					m[i][k-1] = m[i][k];
				}
				m[i][N-1] = temp;
			}
		}
	}

	private static void PrintMatrix(int m[][], int M, int N) {

		for(int i = 0; i < M; i++) {

			for(int j = 0; j < N; j++) {

				System.out.print(m[i][j] + " ");
			}
		}

		System.out.println();
	}
}