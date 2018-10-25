#include <iostream>
using namespace std;

int LBS(int arr[], int n) {
    
    int LIS[n];
    int LDS[n];
    
    for(int i = 0; i < n; i++) {
        
        LIS[i] = 1;
        LDS[i] = 1;
    }
    
    // calculate LIS
    for(int i = 1; i < n; i++)
        for(int j = 0; j < i; j++)
            if(arr[i] > arr[j] && LIS[i] < LIS[j]+1)
                LIS[i] = LIS[j]+1;
    
    // calculate LDS
    for(int i = n-2; i >= 0; i--)
        for(int j = n-1; j > i; j--)
            if(arr[i] > arr[j] && LDS[i] < LDS[j]+1)
                LDS[i] = LDS[j] + 1;
    
    
    int max = LIS[0] + LDS[0] - 1;
    
    for(int i = 1; i < n; i++)
        if((LIS[i] + LDS[i] - 1) > max)
            max = LIS[i] + LDS[i] - 1;
    
    return max;
}

int main() {
	
	int t;
	cin >> t;
	
	while(t--) {
	    
	    int n;
	    cin >> n;
	    
	    int arr[n];
	    
	    for(int i = 0; i < n; i++)
	        cin >> arr[i];
	    
	    cout << LBS(arr, n) << endl;
	}
	
	return 0;
}