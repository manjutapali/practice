#include <iostream>

using namespace std;

void PrintSpiral(int **mat, int n, int m) {

	int t = 0, b = n-1;
	int l = 0, r = m-1;
	int j = 0;
	while(l <= r && t <= b) {

		for(j = l; j <= r; j++)
			cout << mat[t][j] << " ";

		// top row printed, increment top.
		t++;

		for(j = t; j <= b; j++)
			cout << mat[j][r] << " ";

		// right column printed, decrement right.
		r--;

		// Since, two operations on the matrix made, top and
		// bottom or left and right might be equal, check for the
		// conditions.

		// print bottom row, only if it's not reached top. NOTE: Top is already incremented.
		if(t <= b) {

			for(j = r; j >= l; j--)
				cout << mat[b][j] << " ";
		}
		b--;
		// print left col, only if it's not reached right. NOTE: Right is already incremented.
		if(l <= b) {

			for(j = b; j >= t; j--)
				cout << mat[j][l] << " ";
		}
		l++;
	}
}

int main()
{
	int n, m;

	cin >> n >> m;
	
	int **arr = new int*[n];

	for(int i = 0; i < n; i++)
		arr[i] = new int[m];

	for(int i = 0;i < n; i++)
		for(int j = 0; j < m; j++)
			cin >> arr[i][j];

	PrintSpiral(arr, n, m);

	return 0;
}