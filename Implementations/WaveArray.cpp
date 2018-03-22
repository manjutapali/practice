// https://practice.geeksforgeeks.org/problems/wave-array/0

#include <iostream>
#include <algorithm>
using namespace std;

void WaveArray(int arr[], int n)
{
    sort(arr, arr+n);
    
    int i = 0;
    while(i < n && (i+1) < n)
    {
        swap(arr[i], arr[i+1]);
        i += 2;
    }
    
    for(i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    cout << "\n";
}

int main() {
	
	int t, n;
	
	cin >> t;
	
	while(t--)
	{
	    cin >> n;
	    
	    int arr[n];
	    for(int i = 0; i < n; i++)
	    {
	        cin >> arr[i];
	    }
	    
	    WaveArray(arr, n);
	}
	
	return 0;
}