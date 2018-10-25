// Find first sub array with given sum

#include <iostream>

using namespace std;

void PrintSubArray(int arr[], int n, int gsum) {

	int sum = 0;
	int i = 0;
	int j = 0;
	bool flag = false;

	while(i < n) {

		cout << i << " " << j << " " << sum << " " << endl;
		if(sum == gsum) {
			flag = true;
			cout << (i+1) << " " << j;
			break;
		}

		else if(sum > gsum) {
			cout << "sum = " << sum << " " << arr[i] << endl;
			sum -= arr[i];
			i++;
		}
		else if(j < n){
			sum += arr[j];
			j++;
		}

	}

	if(!flag)
		cout << "-1";

	cout << endl;
}

int main(int argc, char const *argv[])
{
	
	int t;
	cin >> t;

	while(t--) {

		int n, sum;
		cin >> n >> sum;

		int arr[n];

		for(int i = 0; i < n; i++)
			cin >> arr[i];

		PrintSubArray(arr, n, sum);
	}

	return 0;
}