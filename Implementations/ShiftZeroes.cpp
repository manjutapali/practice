#include <iostream>
using namespace std;

int shiftZeroes(int arr[], int N) {
    
    int zcount = 0;
    
    int i = 0;
    
    while(i < N-1)
    {
        if(arr[i] == 0) {
            
            int idx = i;
            zcount++;
            while((i+1) < N && arr[i+1] == 0) {
                i++;
                zcount++;
            }
            i++;
            arr[idx] = arr[i];
        }
        else{
            i++;
        }
    }
    
    int j = N-1;
    for(int i = 0; i < zcount; i++) {
        arr[j-i] = 0;
    }
    
    for(int i = 0; i < N; i++)
        cout << arr[i] << " ";
    
    cout << endl;
}

int main() {
	
	int T;
	cin >> T;
	
	while(T--) {
	    
	    int N;
	    cin >> N;
	    
	    int arr[N];
	    
	    for(int i = 0; i < N; i++)
	        cin >> arr[i];
	    
	    shiftZeroes(arr, N);
	}
	return 0;
}