#include <iostream>
#include <string>
	
using namespace std;

int reverse(int num)
{	
	bool neg = false;
	if (num == 0)
	{
		return 0;
	}
	else if (num < 0)
	{
		neg = true;
		num = num * (-1);
	}

	string res = "";
	while(num > 0) {

		int dig = num % 10;
		res += to_string(dig);
		num = num / 10;
	}
	
	int newNum = stoi(res);

	if (neg)
	{
		newNum *= (-1);
	}

	return newNum;
}

int main(int argc, char const *argv[])
{
	
	int num = 210;

	cout << reverse(num) << endl;

	return 0;
}