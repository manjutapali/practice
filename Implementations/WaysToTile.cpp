/*
    Given floor with 2Xn dimension, find ways to allocate 2X1 tile
    The problem follows the pattern of fibonaccci series

    link - https://www.dartmouth.edu/~academicoutreach/docs/fibonacci-numbers-and-tiling.pdf
*/

#include <iostream>
using namespace std;

long long GetNumWays(int);

int main() {

	int T;
	cin >> T;

	for(int i = 0; i < T; i++)
	{
	    int N;
	    cin >> N;

	    cout << GetNumWays(N+1) << endl;

	}

	return 0;
}

long long GetNumWays(int N)
{
    if(N <= 2)
    {
        return 1;
    }

    long long prev = 0;
    long long int curr = 1;
    long long int fib;
    long long int i = 0;

    while(i <= N-2)
    {
        fib = curr + prev;
        prev = curr;
        curr = fib;
        i++;
    }

    return fib;
}
