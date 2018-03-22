// https://practice.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos/0

// Given array of pos and neg num, make alternate pos and neg num.

#include <iostream>
using namespace std;

void PrintResArray(int arr[], int n)
{
    int i = -1;
    int piv = 0;
    for(int j = 0; j < n; j++)
    {
        if(arr[j] < piv)
        {
            i++;
            swap(arr[i], arr[j]);
        }
    }
    
    int pos = i+1;
    int neg = 0;
    
    while(pos < n && neg < n && arr[neg] < 0)
    {
        swap(arr[neg], arr[pos]);
        pos++;
        neg+=2;
    }
    
    for(i = 0; i < n; i++)
        cout << arr[i] << " ";
    cout << "\n";
}

void print(int arr[], int n)
{
    for(int i = 0; i < n; i++)
        cout << arr[i] << " ";
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
	    
	    PrintResArray(arr, n);
	}
	
	return 0;
}