#include <iostream>
#include <vector>
using namespace std;

int main() {
	
	int T;
	cin >> T;
	
	while(T--) {
	    
	    int N;
	    cin >> N;
	    
	    int arr[N];
	    
	    for(int i = 0; i < N; i++) {
	        cin >> arr[i];    
	    }
	    int i = 0;
	    while(i < (N - 1)) {

	    	if(arr[i] != 0 && (arr[i] == arr[i+1])) {
	    		arr[i] = 2*arr[i];
	    		arr[i+1] = 0;
	    		i++;
	    	}
	    	i++;
	    }

	    int res[N];
	    for(i = 0; i < N; i++) {res[i] = 0;}
	    int j = 0;
	    for(i = 0; i < N; i++) {

	    	if(arr[i] != 0) {
	    		res[j] = (arr[i]);
	    		j++;
	    	}
	    }

	    for(int k = 0; k < N; k++) {
	    	cout << res[k] << " ";
	    }
	    cout << endl;
	}
	
	return 0;
}