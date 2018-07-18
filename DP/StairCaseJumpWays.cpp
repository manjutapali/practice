#include <iostream>

using namespace std;

// Recursive
int GetNumWays(int num_steps, int m) {

	if(num_steps <= 1)
		return num_steps;

	int total = 0;

	for(int i = 1; i <= m && i <= num_steps; i++)
		total += GetNumWays(num_steps - i, m);
	return total;
}

int GetNumWaysDP(int num_steps, int m) {

	if(num_steps == 0)
		return 1;

	int t[num_steps+1];

	for(int i = 0; i <= num_steps; i++)
		t[i] = 0;

	t[0] = 1;

	int total;

	for(int i = 1; i <= num_steps; i++) {
		total = 0;
		for(int j = 0; j <= m; j++) {
			if(i - j >= 0)
				total += t[i-j];
		}

		t[i] = total;
	}

	return t[num_steps];
}

int main()
{
	int n, m;
	cin >> n;
	cin >> m;

	cout << GetNumWaysDP(n, m) << endl; // GetNumWays(n+1, m);

	return 0;
}