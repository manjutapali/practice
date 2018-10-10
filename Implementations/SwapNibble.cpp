// Nibble - 4bits in a byte

#include <iostream>

using namespace std;

int swapNibble(int num) {
	// 0x0f - gets last 4 bits, 0xf0 gets first four bits

	return ((num&0x0f) << 4) | ((num&0xf0) >> 4);
}

int main(int argc, char const *argv[])
{
	int t;
	cin >> t;
	while(t--) {
		int num;
		cin >> num;

		cout << swapNibble(num) << endl;
	}

	return 0;
}