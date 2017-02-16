import java.util.*;

class Graph{

    private int V;
    private LinkedList<Integer> adj[];
    public Graph(int v){
        V = v;
        adj = new LinkedList[V];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList();
        }
    }

    public void edge(int v, int u){
        adj[v].add(u);
    }

    public void dfs(int s){
        boolean visited[] = new boolean[V];

        dfsUtil(s, visited);
    }

    private void dfsUtil(int s, boolean visited[]){

        visited[s] = true;
        System.out.print(s +", ");
        Iterator<Integer> itr = adj[s].listIterator();

        while(itr.hasNext()){
            int v = itr.next();
            if(!visited[v]){

                dfsUtil(v, visited);
            }
        }
    }
}

public class DFS{

    public static void main(String[] args) {

        Graph g = new Graph(4);
        g.edge(0, 1);
        g.edge(0, 2);
        g.edge(1, 2);
        g.edge(2, 0);
        g.edge(2, 3);
        g.edge(3, 3);

        g.dfs(2);
    }
}
