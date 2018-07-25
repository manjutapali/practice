#include <string>
#include <sstream>
#include <algorithm>

using namespace std;

int main() {
	
	int t;
	cin >> t;
	
	while(t--) {
	    
	     string x, y;
	     
	     cin >> x >> y;
	     
	     int dig_c_x = x.length();
	     
	     int i = x.length() - 1, j = y.length() - 1;
	     int carry = 0;
	     string res;
	     while(i >= 0 && j >= 0) {
	         
	         int it = x[i] - '0';
	         int jt = y[j] - '0';
	         
	         int sum = it + jt + carry;

	         if(sum > 9) {
	             carry = 1;
	             sum = sum%10;
	             
	             res = res + to_string(sum);
	         }
	         else {
	             res = res + to_string(sum);
	             carry = 0;
	         }
	         
	         i--; j--;
	     }
	     
	     if(j >= 0) {
	         cout << x << endl;
	         continue;
	     }
	     
	     while(i >= 0) {
	         
	         int it = x[i] - '0';
	         int sum = it + carry;
	         
	         if(sum > 9) {
	             carry = 1;
	             sum = sum%10;
	             res = res + to_string(sum);
	         }
	         else {
	             res = res + to_string(sum);
	             carry = 0;
	         }
	         
	         i--;
	     }
	     
	     if(carry == 1)
	        res = res + "1";
	    
	     
	     if(dig_c_x == res.length()) {
	        reverse(res.begin(), res.end());
	        cout << res << endl;
	     }
	     else
	        cout << x << endl;
	}
	
	return 0;
}