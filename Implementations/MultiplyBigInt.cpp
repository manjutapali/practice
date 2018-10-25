// Multiply by 11, given num can have digits upto 1000000
#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

void multiply(string s, string &ans) {

	int carry = 0;
	for(int i = s.length() - 1; i >= 0; i--) {

		int num = s[i] - '0';

		int mul = num * 11 + carry;

		carry = mul/10;
		ans += to_string((mul%10));
	}

	if(carry > 0)
		ans += to_string(carry);

	//cout << ans << endl;

	reverse(ans.begin(), ans.end());
}

int main()
{
	
	int t;
	cin >> t;

	while(t--) {

		string s;
		cin >> s;

		string ans = "";

		multiply(s, ans);

		cout << ans << endl;

	}

	return 0;
}