// check if array represents max heap

#include <iostream>

using namespace std;

bool isHeap(int arr[], int n) {

	for(int i = 0; i < n-1; i++) {

		int left = 2*i + 1;
		int right = 2*i + 2;

		if((left < n && arr[i] < arr[left]) || (right < n && arr[i] < arr[right]))
			return false;
	}

	return true;
}

int main()
{
	int t;
	cin >> t;

	while(t--) {

		int n;
		cin >> n;

		int arr[n];
		for(int i = 0; i < n; i++)
			cin >> arr[i];

		cout << (isHeap(arr, n) ? "YES" : "NO") << endl; 
	}

	return 0;
}