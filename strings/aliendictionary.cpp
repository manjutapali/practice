
//Initial Template for C++
/* script for test case http://code.geeksforgeeks.org/PetjYq */
#include<iostream>
#include<stack>
#include<list>
#include<string>

using namespace std;
string printOrder(string [], int , int );
string order;
bool f(string a,string b)
{
	int p1=0;int p2=0;
	for(int i=0;i<min(a.size(),b.size()) and p1 ==p2;i++ )
	{
		p1 = order.find(a[i]);
		p2 = order.find(b[i]);
	//	cout<<p1<<" "<<p2<<endl;
	}
	
	if(p1 == p2 and a.size()!=b.size())
	return a.size()<b.size();
	
	return p1<p2;
}
	
// Driver program to test above functions
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n,k;
        cin>>n>>k;
        string s[n];
        for(int i=0;i<n;i++)cin>>s[i];
    
        string ss = printOrder(s,n,k);
        /*order="";
        for(int i=0;i<ss.size();i++)
        order+=ss[i];
        
        string temp[n];
        std::copy(s, s + n, temp);
        sort(temp,temp+n,f);
        
        bool f= true;
        for(int i=0;i<n;i++)
        if(s[i]!=temp[i])f=false;
        */
        cout<<ss;
        cout<<endl;
        
    }
	return 0;
}


class Graph {
    
    int v;
    
    list<int> *adj;
    
    void topologicalSortUtil(int vertex, int visited[], stack<int> &s);
    
public:
    Graph(int v);
    
    void addEdge(int v1, int v2);
    
    string topologicalSort();
};

Graph::Graph(int v) {
    this->v = v;
    adj = new list<int>[v];
}

void Graph::addEdge(int v1, int v2) {
    adj[v1].push_back(v2);
}

void Graph::topologicalSortUtil(int vertex, int visited[], stack<int> &s) {
    
    visited[vertex] = 1;
    
    list<int>::iterator i;
    for(i = adj[vertex].begin(); i != adj[vertex].end(); ++i) {
        if(!visited[*i]) {
            topologicalSortUtil(*i, visited, s);
        }   
    }
    
    s.push(vertex);
}

string Graph::topologicalSort() {
    
    stack<int> s;
    cout << "Sort" << endl;
    int visited[v];
    
    for(int i = 0; i < v; i++)
        visited[i] = 0;
        
    for(int i = 0; i < v; i++)
        if(!visited[i])
            topologicalSortUtil(i, visited, s);
    
    
    string ans = "";

    while(s.empty() == false) {
        ans += (char) ('a' + s.top());
        s.pop();
    }
    
    return ans;
}


int min(int x, int y) {
    return (x < y)? x : y;   
}

string printOrder(string dict[], int N, int k)
{
   Graph g(k);
   
   for(int i = 0; i < N-1; i++) {
       
       string w1 = dict[i], w2 = dict[i+1];
       for(int j = 0; j < min(w1.length(), w2.length()); j++) {
           
           if(w1[j] != w2[j]) {
               g.addEdge(w1[j] - 'a', w2[j] - 'a');
               break;
           }
       }
   }
   
   return g.topologicalSort();
}
