#include<iostream>
#include<math.h>

using namespace std;

bool IsElementExist(int arr[], int n, int key, int& idx) {

	int m = sqrt(n);
	int start = 0;
	int end = m - 1;

	idx = -1;
	
	while(arr[min(m, n) - 1] < key) {
		start = m;
		m += sqrt(n);
		end = m - 1;
		if(start >= n) {
			return false;
		}
	}

	while(start <= end) {

		if(arr[start] == key) {
			idx = start;
			return true;
		}

		start++;
	}

	
	return false;
}

int main(int argc, char const *argv[]) {

	int n;
	cin >> n;

	int arr[n];
	for(int i = 0; i < n; i++) { cin >> arr[i]; }

	int key;
	cin >> key;

	// out parameter to get the index;
	int index;
	bool bIsExist = IsElementExist(arr, n, key, index);

	cout << (bIsExist ? "Element exist " : "Element not exist ") << (index) << endl;

	return 0;
}