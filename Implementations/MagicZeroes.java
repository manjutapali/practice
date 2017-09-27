/*
	Given matrix, if an element is zero, set entire col and row to zero.
*/

import java.util.Scanner;

public class MagicZeroes {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int M = in.nextInt();
		int N = in.nextInt();

		int m[][] = new int[M][N];

		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				m[i][j] = in.nextInt();
			}
		}

		PrintMagicMatrix(m, M, N);	
	}

	static void PrintMagicMatrix(int m[][], int M, int N) {
		
		boolean r[] = new boolean[M];
		boolean c[] = new boolean[N];

  		int i = 0, j = 0;
		
		while(i < M && j < N) {

			if(m[i][j] == 0) {
				r[i] = true;
				c[j] = true;
				i++; j++;
			}
			else if(j == N - 1){
				i++;
				j = 0;
			}
			else {
				j++;
			}
		}

		for(i = 0; i < M; i++) {
			if(r[i] == true)
				ChangeRowZeroes(m, i, N);

			if(c[i] == true)
				ChangeColZeroes(m, i, M);
		}

		for(i = 0; i < M; i++){
			for(j = 0; j < N; j++){
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}


	}

	private static void ChangeRowZeroes(int m[][], int idx, int N) {

		for(int i = 0; i < N; i++){
			m[idx][i] = 0;
		}
	}

	private static void ChangeColZeroes(int m[][], int idx, int M) {

		for(int i = 0; i < M; i++){
			m[i][idx] = 0;
		}
	}
}