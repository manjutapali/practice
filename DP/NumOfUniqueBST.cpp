// Given the num N, find number of unique bst can be made from 1 to N.

#include <iostream>

using namespace std;

int GetNumUniqueBST(int n) {

	int L[n+1] = {0};

	L[0] = 1;
	L[1] = 1;

	for(int i = 2; i <= n; i++) {

		for(int j = 0; j < i; j++) {
			L[i] += L[j] * L[j-i-1];
		}
	}

	return L[n];

}

int main(int argc, char const *argv[])
{
	
	int T;
	cin >> T;

	while(T--) {

		int num;
		cin >> num;

		cout << GetNumUniqueBST(num) << endl;
	}

	return 0;
}