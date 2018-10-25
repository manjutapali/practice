// Given the mobile numeric keypad and allowed to press the button
// that are up, down, left, right to the current button. Given number N
// find out the number of possible numbers of given length N.

#include <iostream>

using namespace std;

// moves
int R[] = {0, 0, -1, 0, 1};
int C[] = {0, -1, 0, 1, 0};

// keypad
char keypad[4][3] = {{'1', '2', '3'},
					 {'4', '5', '6'},
					 {'7', '8', '9'},
					 {'*', '0', '#'}
					};

// Recursive approach
long long int GetNumCountUtil(char keypad[][3], int r, int c, int n) {

	if(n <= 0)
		return 0;

	if(n == 1)
		return 1;


	int ri = 0, cj = 0;
	long long int total = 0;

	for (int i = 0; i < 5; ++i)
	{
		ri = r + R[i];
		cj = c + C[i];

		if( ri >= 0 && ri <= 3 &&
			cj >= 0 && cj <= 2 &&
			keypad[ri][cj] != '*' &&
			keypad[ri][cj] != '#' 
			) {

			total += GetNumCountUtil(keypad, ri, cj, n-1);
		}
	}

	return total;
}

long long int GetNumCount(int n) {

	if(n <= 0)
		return 0;

	if(n == 1)
		return 10;

	long long int total = 0;

	for (int i = 0; i < 4; ++i) {

		for(int j = 0; j < 3; j++) {

			if(keypad[i][j] != '*' && keypad[i][j] != '#') {

				total += GetNumCountUtil(keypad, i, j, n);
			}
		}
	}

	return total;
}

long long int GetNumCountDP(int n) {

	if(n <= 0)
		return 0;

	if(n == 1)
		return 10;

	// 10 digits, length n.
	long long int t[10][n+1];

	for(int i = 0; i < 10; i++) {

		t[i][0] = 0;
		t[i][1] = 1;
	}

	// start with length 2,3...n
	for(int k = 2; k <= n; k++) {

		for(int i = 0; i < 4; i++) {

			for(int j = 0; j < 3; j++) {

				if(keypad[i][j] != '*' && keypad[i][j] != '#') {

					int num = keypad[i][j] - '0';

					t[num][k] = 0;

					for(int l = 0; l < 5; l++) {

						int ri = i + R[l];
						int cj = j + C[l];
						int nextNum = 0;
						if( ri >= 0 && ri <= 3 &&
							cj >= 0 && cj <= 2 &&
							keypad[ri][cj] != '*' &&
							keypad[ri][cj] != '#' 
						) {

							nextNum = keypad[ri][cj] - '0';
							t[num][k] += t[nextNum][k-1];

						}

					}
				}
			}
		}
	}

	long long int total = 0;

	for (int i = 0; i < 10; ++i) {
		total += t[i][n];
	}

	return total;
}

int main()
{
	int T;
	cin >> T;

	while(T--) {

		int n;
		cin >> n;

		cout << GetNumCountDP(n) << endl;
	}
	
	return 0;
}