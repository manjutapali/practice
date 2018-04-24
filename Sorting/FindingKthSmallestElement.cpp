#include<iostream>
#include<vector>
#include <climits>

using namespace std;

int partition(int arr[], int l, int r, int pivot) {
    
    int i = l - 1;

    for(int j = l; j < r; j++) {

        if(arr[j] < pivot) {
            i += 1;
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    int t = arr[i+1];
    arr[i+1] = arr[r];
    arr[r] = t;

    return i+1;
}

int quickSelect(int arr[], int l, int r, int k) {
    
    if(k > 0 && l < r) {

        int pivot = arr[r];

        int idx = partition(arr, l, r, pivot);

        if(idx == k )
            return arr[k];
        else if (idx < k)
            return quickSelect(arr, l, idx-1, k);
        else
            return quickSelect(arr, idx+1, r, k);
    }
    
    return arr[k];
}

int main() {

    // vector<int> arr;
    int arr[5] = {44, 23, 37, 56, 48};

    cout << quickSelect(arr, 0, 4, 2) << endl;
}