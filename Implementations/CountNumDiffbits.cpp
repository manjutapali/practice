// Find sum of different corresponding bits for all pairs

#include <iostream>

using namespace std;

int CountDiffBits(int arr[], int n) {

	int ans = 0;
	// Number is represented in 32 bit. Get the number of setbits in the column.
	for (int i = 0; i < 32; ++i) {	
		int count = 0;
		
		for (int j = 0; j < n; ++j) {
			if(arr[j] & (1<<i))
				count++;
		}

		ans = (ans + count * (n - count) * 2) % 1000000009;
	}

	return ans;
}

int main(int argc, char const *argv[]) {
	int t;
	cin >> t;

	while(t--) {
		int n;
		cin >> n;

		int arr[n];

		for(int i = 0; i < n; i++)
			cin >> arr[i];

		CountDiffBits(arr, n);
	}
	return 0;
}