// https://practice.geeksforgeeks.org/problems/magnet-array-problem/0

#include <cmath>
#include <iomanip>

using namespace std;

double ForceOnPoint(double point, double arr[], int n) {
    
    double netForce = 0;
    
    for(int i = 0; i < n; i++) {
        netForce += 1/(point - arr[i]);
    }
    
    return netForce;
}

double FindPoint(double point1, double point2, double arr[], int n) {
    
    double mid;
    
    while(point2 > point1) {
        mid = point1 + (point2 - point1)/2;
        
        double f = ForceOnPoint(mid, arr, n);
        
        if(abs(f) < 0.0000000000001)
            return mid;
        else if(f > 0)
            point1 = mid;
        else
            point2 = mid;
    }
    
    return point1;
}

int main()
 {
	int t;
	cin >> t;
	
	while(t--) {
	    
	    int n;
	    cin >> n;
	    double arr[n];
	    for(int i = 0; i < n; i++)
	        cin >> arr[i];
	    
	    for(int i = 0; i < n-1; i++) {
	        cout <<fixed << setprecision(2) << FindPoint(arr[i], arr[i+1], arr, n) << " ";
	    }
	    cout << endl;
	}
	return 0;
}