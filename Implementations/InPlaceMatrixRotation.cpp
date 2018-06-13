// Rotate the squre matrix anti-clockwise by 90, without using extra space

#include <iostream>

using namespace std;

int N = 0;

void RotateMatrix(int *m[N]) {

	// There will be n/2 spirals.
	// Need to swap top-right to top-left, top-left to bottom-left, bottom-left to bottom-right, bottom-right to top-left
	for(int i = 0; i < N/2; i++) {

		for(int j = i; j < N - 1 - i; j++) {

			int t = m[i][j];
			m[i][j] = m[j][N - 1 - i];
			m[j][N - 1 - i] = m[N - 1 - i][N - 1 - j];
			m[N - 1 - i][N - 1 - j] = m[N - 1 - j][i];
			m[N - 1 - j][i] = t;
		}
	}
}

void DisplayMatrix(int m[][N]) {

	for(int i = 0; i < N; i++) {

		for(int j = 0; j < N; j++) {

			cout << m[i+j] << "\t";
		}

		cout << endl;
	}
}

int main() {

	cin >> N;

	int m[N][N];

	for(int i = 0; i < N; i++) {

		for(int j = 0; j < N; j++) {

			cin >> m[i][j];
		}
	}

	DisplayMatrix(m);

	return 0;
}