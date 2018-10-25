#include <iostream>
#include <queue>

using namespace std;

int main() {
	
	int t;
	cin >> t;
	
	while(t--) {
	    
	    int n;
	    cin >> n;
	    
	    vector<char> v(n);
	    
	    for(int i = 0; i < n; i++)
	        cin >> v[i];
	        
	    int freq[26] = {0};
	    
	    queue<char> q;
	    for(int i = 0; i < n; i++) {
	        
	        freq[(v[i] - 'a')]++;
	        
	        q.push(v[i]);
	        
	        while(!q.empty()) {
	            
	            if(freq[q.front() - 'a'] > 1) {
	            	q.pop();
	            }
	            else {
	            	cout << q.front() << " ";
	            	break;
	            }
	        }

	        if(q.empty())
	        	cout << "-1" << " ";
	    }

	    cout << endl;
	}
	return 0;
}