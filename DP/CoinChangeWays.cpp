#include <iostream>

using namespace std;

int CountWays(int coins[], int n, int sum) {

	if(sum == 0)
		return 1;

	if(sum < 0)
		return 0;

	if(n <= 0 && sum >= 1)
		return 0;

	return CountWays(coins, n-1, sum) + CountWays(coins, n, sum - coins[n-1]);
}

int CountWaysDP(int coins[], int n, int sum) {

	int t[n+1][sum+1];

	for(int i = 0; i <= n; i++)
		for(int j = 0; j <= sum; j++)
			t[i][j] = 0;

	for(int i = 0; i <= n; i++)
		t[i][0] = 1;

	for(int i = 1; i <= n; i++) {

		for(int j = 1; j <= sum; j++) {

			if(coins[i-1] > j)
				t[i][j] = t[i-1][j];
			else
				t[i][j] = t[i-1][j] + t[i][j-coins[i-1]];
		}
	}

	return t[n][sum];
}

int main()
{
	
	int sum, n;
	cin >> sum;

	cin >> n;

	int arr[n];

	for(int i = 0; i < n; i++)
		cin >> arr[i];

	cout << CountWaysDP(arr, n, sum) << endl;

	return 0;
}