#include <iostream>
#include <vector>

using namespace std;

void addEdge(vector<int> adj[], int u, int v) {
	
	adj[u].push_back(v);
}

int findDependencySum(vector<int> adj[], int V) {

	int sum = 0;

	for(int i = 0; i < V; i++)
		sum += adj[i].size();

	return sum;
}


int main(int argc, char const *argv[])
{
	int V = 4;
	vector<int> adj[4];
	
	addEdge(adj, 0, 2);
	addEdge(adj, 0, 3);
	addEdge(adj, 1, 3);
	addEdge(adj, 2, 3);

	cout << "Dependency sum = " << findDependencySum(adj, V) << endl;

	return 0;
}