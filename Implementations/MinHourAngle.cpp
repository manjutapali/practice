#include <iostream>
#include <cmath>


using namespace std;

void PrintAngle(double , double);

int main() {
	int T;
	cin >> T;

	for(int i = 0; i < T; i ++)
	{
	    double hr, min;

	    cin >> hr;
	    cin >> min;

	    PrintAngle(hr, min);
	}

	return 0;
}

void PrintAngle(double hr, double min)
{
    double min_hand = 360 / 60; // min hand will cover 6 degrees per minute
    double hr_hand = (360.0 / 12) / 60; // hour hand will cover 0.5 degrees per minute

    if (min == 60)
	{
		min = 0;
	}

    double min_hand_angle = min * min_hand;
    double hr_hand_angle = hr * 60 * hr_hand + min * hr_hand;

    double diff1 = abs(min_hand_angle - hr_hand_angle);
    double diff2 = 360 - diff1;
    double angle = diff1 < diff2 ? diff1 : diff2;

    cout << floor(angle) << endl;
}
