#include <iostream>

using namespace std;

bool isSafePath(int **g,int row, int col, int n, int m, bool **visited)
{
    if(row >= 0 && col >= 0 && row < n && col < m && g[row][col] && !visited[row][col])
        return true;

    return false;
}

void DFSUtil(int **g, int i, int j,int n, int m, bool **visited, int &res)
{
    visited[i][j] = true;
    int paths = 8; // Number of neighbours considering the allowed paths

    // neighbour indices
    static int row[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int col[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    res++;
    for(int k = 0; k < paths; k++)
    {
        if(isSafePath(g, i+row[k], j+col[k],n, m, visited))
            DFSUtil(g, i+row[k], j+col[k],n, m, visited, res);
    }

}

int longestPath(int **g, int n, int m)
{
    bool **visited = new bool*[n];

    for(int i = 0; i < n; i++)
    	visited[i] = new bool[m];

    for (int i = 0; i < n; ++i)
    	for(int j = 0; j < m; j++)
    		visited[i][j] = false;
    

    int longest_path = 0;

    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < m; j++)
        {
            if(g[i][j] && !visited[i][j])
            {
            	int res = 0;
                DFSUtil(g, i, j ,n, m, visited, res);
                
                longest_path = max(longest_path, res);
            }
        }
    }

    return longest_path;
}

int main() {

	int t;
	cin >> t;

	while(t--) {

		int n, m;
		cin >> n >> m;

		int **g = new int*[n];

		for(int i = 0; i < n; i++)
			g[i] = new int[m];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				cin >> g[i][j];
			}
		}

		cout << longestPath(g, n, m) << endl;
	}
}
