#include <iostream>
using namespace std;

void printIndices(int* , int , int );
int Bsearch(int* , int ,int , int);

int main() {
	int T;
	cin >> T;

	for(int i = 0; i < T; i++)
	{
	    int N, x;
	    cin >> N;
	    int arr[N];
	    for(int i = 0; i < N; i++)
	    {
	        cin >> arr[i];
	    }

	    cin >> x;

	    printIndices(arr, x, N);
	}
	return 0;
}

void printIndices(int arr[], int x, int N)
{
    int idx = Bsearch(arr, x, 0, N);
    if(idx == -1)
    {
        cout << -1 << endl;
        return;
    }

    int fidx = idx;
    int lidx = idx;
    bool flag1 = false;
    bool flag2 = false;

    while(fidx >= 0 || lidx <= N - 1)
    {
        if(fidx >= 0 && arr[fidx - 1] == x)
            fidx--;
        else
            flag1 = true;

        if(lidx + 1 <= N-1 && arr[lidx + 1] == x)
            lidx++;
        else
            flag2 = true;

        if(flag1 && flag2)
            break;
    }

    cout << fidx << " " << lidx <<"\n";
}

int Bsearch(int arr[], int x, int st, int en)
{
    while(st <= en)
    {
        int mid = (st + en) / 2;

        if(arr[mid] == x)
            return mid;
        else if(arr[mid] < x)
            st = mid + 1;
        else
            en = mid - 1;
    }

    return -1;
}
