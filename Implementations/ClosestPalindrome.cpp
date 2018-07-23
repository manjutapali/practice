#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

string GetClosestPal(string num) {

	string num_temp(num);

	reverse(num_temp.begin(), num_temp.end());

	if(num_temp == num) {
		return num;
	}

	string s1 = "";
	
	if(num.length()%2 == 0) {
		s1 = num.substr(0, num.length()/2);
	}
	else{
		s1 = num.substr(0, num.length()/2 + 1);
	}

	string s2 = to_string((stoi(s1) + 1));
	string s3 = to_string((stoi(s1) - 1));

	string temp1, temp2, temp3;
	if(num.length()%2 == 0) {
		
		temp1 = s1;
		reverse(s1.begin(), s1.end());
		temp1 += s1;

		temp2 = s2;
		reverse(s2.begin(), s2.end());
		temp2 += s2;

		temp3 = s3;
		reverse(s3.begin(), s3.end());
		temp3 += s3;


	}
	else {

		temp1 = s1;
		reverse(s1.begin(), s1.end());
		temp1 += s1.substr(1, s1.length());

		temp2 = s2;
		reverse(s2.begin(), s2.end());
		temp2 += s2.substr(1, s2.length());

		temp3 = s3;
		reverse(s3.begin(), s3.end());
		temp3 += s3.substr(1, s3.length());
	}

	int d1 = fabs(stoi(temp1) - stoi(num));
	int d2 = fabs(stoi(temp2) - stoi(num));
	int d3 = fabs(stoi(temp3) - stoi(num));

	// cout << temp1 << ", " << temp2 << ", " << temp3 << ", " << endl;
	
	if(d1 == d2) {

		if(temp1 < temp2)
			return temp1;
		else
			return temp2;
	}
	else if(d2 == d3) {

		if(temp2 < temp3)
			return temp2;
		else
			return temp3;
	}
	else if(d1 == d3) {

		if(temp1 < temp3)
			return temp1;
		else 
			return temp3;
	}
	else {

		if(d1 < d2 && d1 < d3)
			return temp1;
		else if(d2 < d1 && d2 < d3)
			return temp2;
		else
			return temp3;
	}
}
int main()
{
	int t;
	cin >> t;

	while(t--) {

		string num;
		cin >> num;

		cout << GetClosestPal(num) << endl;
	}

	return 0;
}