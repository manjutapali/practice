// count sub-arrays having product less than k.
#include <iostream>

using namespace std;

typedef long long int ll;

void PrintCountSubArrays(int arr[], ll n, ll k) {

	int count = 0;
	int high = 0, low = 0;
	ll prod = arr[0];

	while(high < n) {

		if(prod < k)
			count += high - low + 1;
		else {

			while(low <= high && prod >= k) {

				prod /= arr[low];
				low++;
			}

			if(low <= high)
				count += high - low + 1;
		}

		high++;
		if(high == n)
			continue;

		prod *= arr[high];
	}

	cout << count << endl;
}

int main(int argc, char const *argv[])
{
	
	int T;
	cin >> T;

	while(T--) {

		int n;
		cin >> n;

		ll k;
		cin >> k;

		int arr[n];

		for(int i = 0; i < n; i++)
			cin >> arr[i];

		PrintCountSubArrays(arr, n, k);

	}

	return 0;
}