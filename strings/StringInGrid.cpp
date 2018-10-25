// Find the occurances of given word in the grid.
// Consider all eight directions

#include<iostream>
#include<string>

using namespace std;

int x[] = {-1, -1, -1, 0, 1, 1, 1, 0};
int y[] = {-1, 0, 1, 1, 1, 0, -1, -1};

bool checkPattern(char **grid, string str, int row, int col, int R, int C) {
    
    if(grid[row][col] != str[0])
        return false;
    
    int len = str.length();
    
    for(int d = 0; d < 8; d++) {
        
        int k, rd = row + x[d], cd = col + y[d];
        
        for(k = 1; k < len; k++) {
            
            if(rd >= R || rd < 0 || cd >= C || cd < 0)
                break;
            
            if(grid[rd][cd] != str[k])
                break;
            
            rd += x[d]; cd += y[d];
        }
        
        if(len == k)
            return true;
    }
    
    return false;
}

void PrintMatchIdx(char **grid, string str, int R, int C) {
    
    bool flag = false;
    for(int i = 0; i < R; i++)
        for(int j = 0; j < C; j++)
            if(checkPattern(grid, str, i, j, R, C)) {
                flag = true;
                cout << i << " " << j << ", ";
            }
    
    if(!flag)
        cout << "-1";
    cout << endl;
}

int main()
 {
	int t;
	cin >> t;
	
	while(t--) {
	    int m,n;
	    cin >> m >> n;
	    
	    char **grid = new char*[m];
	    for(int i = 0; i < m; i++)
	        grid[i] = new char[n];
	    
	    
	    for(int i = 0; i < m; i++)
	        for(int j = 0; j < n; j++)
	            cin >> grid[i][j];
	    
	    string str;
	    cin >> str;
	    
	    PrintMatchIdx(grid, str, m, n);
	}
	return 0;
}