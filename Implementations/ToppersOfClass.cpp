#include <iostream>
#include <algorithm>
#include <vector>
#include <set>

using namespace std;

struct m_pair
{
	long long int first;
	int second;
};

bool compare(m_pair a, m_pair b) {
    return ((a.first == b.first ) && (a.second < b.second))
            || (a.first > b.first);
}

int main() {
	
	int t;
	cin >> t;
	
	while(t--) {
	    
	    int n;
	    cin >> n;
	    
	    vector<m_pair> v(n);
	    
	    for(int i = 0; i < n; i++) {
	        cin >> v[i].first;
	        v[i].second = i;
	    }
	    
	    long long int k;
	    cin >> k;
	    
	    sort(v.begin(), v.end(), compare);
	    
	    set<int> s;

	    for(int i = 0; i < n; i++) {

	    	s.insert(v[i].first);
	    	if(s.size() > k)
	    		break;

	        cout<< v[i].second <<" ";
	    }
	    cout << endl;
	}
	
	return 0;
}