/*
    Given n strings sort lexicographical order
*/

#include<iostream>
#include<string>

using namespace std;

int main()
{
    string arr[3], temp;

    for(int i = 0; i < 3; i++)
    {
        getline(cin, arr[i]);
    }

    for(int i = 0; i < 2; i++)
    {
        for(int j = i+1; j < 3; j++)
        {
            if(arr[i].compare(arr[j]) > 0)
            {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    }

    cout << "Sorted order" << endl;
    for(int i = 0; i < 3; i++)
    {
        cout << arr[i] + "\n";
    }

    return 0;
}
