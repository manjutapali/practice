#include <iostream>
#include <vector>
using namespace std;

void merge(vector<int>& arr, int l, int m, int r) {

	int i, j, k;

	int n1 = m - l + 1;
	int n2 = r - m;

	int L[n1], R[n2];

	for(i = 0; i < n1; i++) {
		L[i] = arr[i+l];
	}

	for(i = 0; i < n2; i++) {
		R[i] = arr[m + 1 + i];
	}

	i = 0; j = 0;
	k = l;

	while(i < n1 && j < n2)
	{
		if(L[i] <= R[i]) {
			arr[k] = L[i];
			i++; k++;
		}
		else {
			arr[k] = R[j];
			j++; k++; 
		}
	}

	while(i < n1) {
		arr[k] = L[i];
		i++; k++;
	}

	while(j < n2) {
		arr[k] = R[j];
		j++; k++;
	}
}

void sort(vector<int>& arr, int l, int r) {

	if(l < r) {

		int m = l + (r - l) / 2;

		sort(arr, l, m);
		sort(arr, m+1, r);

		merge(arr, l, m, r);
	}
}

void display(vector<int>& arr) {

	for(int i = 0; i < arr.size(); i++) {

		cout << arr[i] << ", ";
	}

	cout << "\n" ;
}

int main() 
{

	vector<int> arr;

	arr.push_back(8); arr.push_back(11); arr.push_back(4); arr.push_back(6); arr.push_back(15); arr.push_back(13); 

	sort(arr, 0, arr.size());

	display(arr);
}