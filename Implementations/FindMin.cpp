/*
  Finding min element in sorted and rotated array
*/

#include <iostream>
using namespace std;

void findMin(int *, int);

int main() {
	int T;
	cin >> T;

	for(int i = 0; i < T; i++)
	{
	    int N;
	    cin >> N;

	    int a[N];

	    for(int j = 0; j < N; j++)
	    {
	        cin >> a[j];
	    }

	    findMin(a, N);
	}
	return 0;
}

void findMin(int a[], int N)
{

    for(int i = 1; i < N; i++)
    {
        if(a[i] < a[i-1])
        {
            cout << a[i] << endl;
            return;
        }
    }

    cout << a[0] << endl;
}
