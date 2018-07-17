#include<iostream>
#include<climits>

using namespace std;

void PrintArr(int arr[]) {

	int n = sizeof(arr) / sizeof(arr[0]);

	for(int i = 0; i <= n; i++)
		if(arr[i] != INT_MIN)
			cout << arr[i] << " ";

	cout << "\n";
}

void PrintSubSetsUtil(int arr[], int res[], int idx) {

	if(idx == sizeof(arr)/sizeof(arr[0])+1)
		PrintArr(res);
	
	else {
		res[idx] = INT_MIN;
		PrintSubSetsUtil(arr, res, idx+1);
		res[idx] = arr[idx];
		PrintSubSetsUtil(arr, res, idx+1);
	}
}

void PrintSubSets(int arr[]) {

	int n = sizeof(arr) / sizeof(0);

	int res[n];

	PrintSubSetsUtil(arr, res, 0);
}

int main() {

	int arr[3];
	arr[0] = 1;
	arr[1] = 4;
	arr[2] = 3;
	PrintSubSets(arr);
}
