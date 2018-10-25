// Given two numbers A and B, count number of bits to be flipped 
// to convert A to B.

#include <iostream>

using namespace std;

int CountFlipBits(int a, int b) {

	int xor_a_b = a ^ b;
	int count = 0;

	while(xor_a_b) {

		count += xor_a_b & 1;
		xor_a_b >>= 1;
	}

	return count;
}

int main(int argc, char const *argv[])
{	
	int t;

	cin >> t;

	while(t--) {

		int a, b;
		cin >> a >> b;

		cout << CountFlipBits(a, b) << endl;
	}

	return 0;
}