/* 
	Given n number of blocks of size 1, find the max height of staircase
	can be made. sequence should be of 1,2,3,4.....
*/

#include<iostream>
#include<cmath>

using namespace std;

int main() {

	int t;
	cin >> t;

	while(t--) {

		int n;
		cin >> n;

		// eq formed is height(height+1) <= 2*n
		// finding roots of the qudratic equation

		int ans = (-1 + sqrt(1+8*n))/2;

		cout << ans << endl;
	}
}