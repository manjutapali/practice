#include <iostream>
#include<string>
#include <algorithm>

using namespace std;

string AddBinNums(string a, string b) {

	string res = "";

	int i = a.length() - 1, j = b.length() - 1;

	int carry = 0;
	while(i >= 0 && j >= 0) {

		int sum = carry + (a[i] - '0') + (b[j] - '0');
		cout << sum << endl;
		if (sum > 1)
		{
			carry = 1;
			res += to_string((sum % 2));
		}
		else {
			carry = 0;
			res += to_string(sum);
		}

		i--; j--;
	}

	while(i >= 0) {
		int sum = carry + (a[i] - '0');
		if (sum > 1)
		{
			carry = 1;
			res += to_string((sum % 2));
		}
		else {
			carry = 0;
			res += to_string(sum);
		}
		i--;
	}

	while( j >= 0) {
		int sum = carry + (b[j] - '0');
		if (sum > 1)
		{
			carry = 1;
			res += to_string((sum%2));
		}
		else {
			carry = 0;
			res += to_string(sum);
		}

		j--;
	}

	if (carry == 1)
	{
		res += to_string(carry);
	}
	reverse(res.begin(), res.end());
	return res;
}

int main(int argc, char const *argv[])
{
	
	string a = "1010";
	string b = "1011";

	string res = AddBinNums(a,b);

	cout << res << endl;

	return 0;
}