#include <iostream>
#include <string>

using namespace std;

int main(int argc, char const *argv[]) {

    string str;
    getline(cin, str);
    int alphaCount = 0;
    int digCount = 0;

    for(int i = 0; i < str.size(); i++)
    {
        char c = str[i];
        if((c >= 65 && c <= 90) || (c >= 97 && c <= 122))
        {
            alphaCount++;
        }
        else if(c >= 48 && c <= 57)
        {
            digCount++;
        }
    }

    cout << "Alphabets Count = " << alphaCount << endl;
    cout << "Digits count = " << digCount << endl;

  return 0;
}
