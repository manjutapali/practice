#include <iostream>
#include <cstring>

using namespace std;

const int c = 5;
const int r = 5;

/*
 The allowed path is horizontal, vertical and diagonal
*/

bool isSafePath(int m[][c],int row, int col, bool visited[][c])
{
    if(row >= 0 && col >= 0 && row < r && col < c && m[row][col] && !visited[row][col])
        return true;

    return false;
}

void DFSUtil(int m[][c], int i, int j, bool visited[][c])
{
    visited[i][j] = true;
    int paths = 8; // Number of neighbours considering the allowed paths

    // neighbour indices
    static int row[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int col[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    for(int k = 0; k < paths; k++)
    {
        if(isSafePath(m, i+row[k], j+col[k], visited))
            DFSUtil(m, i+row[k], j+col[k], visited);
    }

}

int countIsland(int M[][c])
{
    bool visited[r][c];
    memset(visited, 0, sizeof(visited));

    int numOfIsland = 0;

    for(int i = 0; i < r; i++)
    {
        for(int j = 0; j < c; j++)
        {
            if(M[i][j] && !visited[i][j])
            {
                DFSUtil(M, i, j, visited);
                numOfIsland++;
            }
        }
    }

    return numOfIsland;
}

int main()
{
    int M[][c] = {  {1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1}
    };

    cout << "Number of Island : " << countIsland(M) << endl;
}
