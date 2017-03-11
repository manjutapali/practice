/*
It was a very boring day, so a geek thought to play a game with his friends.
To make the day interseting he started playing game. The game was very simple,
he intitialised number to all his friends and made them stand in increasing order.
eg. 1,2,3,4,5......

Now he eleminates the players at odd places and few are left. 2,4...
Again he eleminates the players at odd places and he do this util only one of his
friend is left in this game. 4... And the only player left wins.
Now the task geek assigned you was that you have to find which of his friend will win.
*/

#include <iostream>
using namespace std;

void PrintWinner(int);

int main() {
	//code

	int T;
	cin >> T;

	for(int i = 0; i < T; i++)
	{
	    int N;
	    cin >> N;

	    PrintWinner(N);
	}

	return 0;
}

void PrintWinner(int N)
{
    int ans = 2;
    int prev = ans;

    if(N == 1)
    {
        cout << 1 << endl;
        return;
    }


    while(ans <= N)
    {
        prev = ans;
        ans = ans << 1;
    }

    cout << prev << endl;
}
