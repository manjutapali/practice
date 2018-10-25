#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

struct AB
{
	int a;
	int b;
};

bool comparator(AB x, AB y) {
	return (fabs(x.a - x.b) >= fabs(y.a - y.b));
}

int main(int argc, char const *argv[])
{
	int t;
	cin >> t;

	while(t--) {
		int N, X, Y;

		cin >> N;
		cin >> X;
		cin >> Y;

		std::vector<AB> v(N);

		for(int i = 0; i < N; i++) cin >> v[i].a;
		for(int i = 0; i < N; i++) cin >> v[i].b;

		sort(v.begin(), v.end(), comparator);

		int tip = 0;

		for(int i = 0; i < N; i++) {

			if(X > 0 && (v[i].a >= v[i].b) || (Y == 0)) {
				X--;
				tip += v[i].a;
			}
			else if(Y > 0 && (v[i].b > v[i].a) || (X == 0)) {
				Y--;
				tip += v[i].b;
			}
		}

		cout << tip << endl;
	}
	return 0;
}