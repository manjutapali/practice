#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

class slot {
public:
    int start_t;
    int end_t;
    
    slot() {
        start_t = 0;
        end_t = 0;
    }
};

bool sortby(const pair<int,slot> &a, 
              const pair<int,slot> &b) 
{ 
    return (a.first < b.first); 
} 

int main() {
    
    int t;
    cin >> t;
    
    while(t--) {
        int n;
        cin >> n;
        
        vector<pair<int, slot> > v(n);
        
        for(int i = 0; i < n; i++) {
            slot t;
            int a,b;
            cin >> a >> b;
            t.start_t = a;
            t.end_t = b;
            v[i] = make_pair(t.end_t - t.start_t, t);
        }
        
        sort(v.begin(), v.end(), sortby);
        
        int alice_c = 0, bob_c = 0;
        int size = n;
        int turn = 0;
        //int st = 0;
        
        while(size) {
           int count = 0;
           int i = 0;
           int et = 0;
           while(i < size) {
               slot k = v[i].second;
               if(k.start_t > et) {
                    count++;
                    et = k.end_t;
                    v.erase(v.begin()+i);
                    size = v.size();
                    continue;
               }
               
              i++;
              cout << "i val = " << i << endl;
           }
           
           if(turn%2 == 0) {
               if(alice_c == 0)
                    alice_c = count;
                else
                    alice_c ^= count;
           }
           else {
               if(bob_c == 0)
                    bob_c = count;
                else
                    bob_c ^= count;
           }
           
           size = v.size();
           turn++;

           cout << turn << endl;
        }
        
        string s;
        
        if(alice_c > bob_c)
            s = "Alice";
        else if(alice_c < bob_c)
            s = "Bob";
        else
            s = "Tie";
        
        cout << s << endl;
    }
}