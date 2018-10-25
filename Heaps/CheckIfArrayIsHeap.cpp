#include <iostream>

using namespace std;

int IsHeap(int arr[], int n) {
    
    for(int i = 0; i < n-1; i++) {
        
        int left = 2*i + 1;
        int right = 2*i + 2;
        
        if((left < n && arr[left] > arr[i]) || 
            ((right < n) && arr[right] > arr[i]))
            return 0;
        
    }
    
    return 1;
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
	    
	    cout << IsHeap(arr, n) << endl; 
	}
	
	return 0;
}