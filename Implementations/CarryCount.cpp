#include<iostream>
#include<string>

using namespace std;

int main()
 {
	int t;
	cin >> t;
	
	while(t--) {
	    
	    string s1, s2;
	    cin >> s1;
	    cin >> s2;
	    
	    int i1 = s1.length()-1;
	    int i2 = s2.length()-1;
	    int carry = 0, count = 0;
	    
	    while(i1 >= 0 && i2 >= 0) {
	        
	        int sum = (s1[i1] - '0') + (s2[i2] - '0') + carry;

	        carry = sum / 10;

	        cout << sum << " " << s1[i1] << " " << s2[i2] << carry << endl;
	        
	        if(carry > 0)
	            count++;
	            
	       i1--;
	       i2--;
	       
	    }
	    
	    while(i1 >= 0) {
	        int sum = s1[i1] - '0' + carry;
	        //cout << sum << " " << s1[i1] << " " << carry << endl;
	        carry = sum / 10;
	        
	        if(carry > 0)
	            count++;
	        else
	            break;
	       
	       i1--;

	    }
	    
	    while(i2 >= 0) {
	        int sum = s2[i2] - '0' + carry;
	        //cout << sum << " " << s2[i2] << " " << carry<< endl;
	        carry = sum / 10;
	        if(carry > 0)
	            count++;
	        else
	            break;
	        
	        i2--;


	    }
	    
	    cout << count << endl;
	}
	return 0;
}