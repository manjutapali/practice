// Find ith character in binary converetd decimal, where 1 - 10 & 0 - 01 for n iterations

#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

string GetBinary(int m) {

	string res;

	while(m) {

		int rem = m % 2;
		res += rem + '0';
		m = m / 2;
	}

	reverse(res.begin(), res.end());

	return res;
}

char GetIthChar(int m, int k, int n) {

	string s = GetBinary(m);

	cout << s << endl;

	string res;

	for(int i = 0; i < n; i++) {

		for(int j = 0; j < s.length(); j++) {

			if(s[j] == '1')
				res += "10";
			else
				res += "01";
		}

		s = res;
		res = "";
	}

	cout << s << endl;
	return s[k];
}

int main() {

	int T, m, k, n;

	cin >> T;

	while(T--) {

		cin >> m;
		cin >> k;
		cin >> n;

		cout << GetIthChar(m,k,n) << endl;
	}

	return 0;
}