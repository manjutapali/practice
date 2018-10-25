#include <iostream>

using namespace std;

int GetSize(int **arr, int n, int m) {

	int t[n][m];

	int max = -1;

	for(int i = 0; i < n; i++)
		for(int j = 0; j < m; j++)
			t[i][j] = arr[i][j];

	// Considering squre of size 2 in mtarix.
	// Logic is to find, the min among (i-1, j), (i-1)(j-1), (i, j-1).
	// Add min to the current.
	for(int i = 0; i < n; i++) {

		for(int j = 0; j < m; j++) {
			
			// Keep the border elements same.
			if(i == 0 || j == 0)
				continue;

			if(t[i][j] == 1)
			{
				t[i][j] = 1 + min(t[i-1][j-1], min(t[i-1][j], t[i][j-1]));
			}

			if(max < t[i][j])
				max = t[i][j];
		}
	}

	return max;
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

	int incl;
	cout << GetSize(arr, n, m) << endl;

	return 0;
}