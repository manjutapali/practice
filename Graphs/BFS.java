import java.util.*;

class Graph{

    private int V;
    private LinkedList<Integer> adj[];

    public Graph(int v){
        V = v;
        adj = new LinkedList[V];

        for(int i = 0; i < V; i++){
            adj[i] = new LinkedList();
        }
    }

    public void edge(int v, int u){
        adj[v].add(u);
    }

    public void bfs(int s){
        bfsUtil(s);
    }

    private void bfsUtil(int s){
        boolean visited[] = new boolean[V];

        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] = true;

        while(q.size() != 0){

            int v = q.poll();
            System.out.print(v + ", ");

            Iterator<Integer> itr = adj[v].listIterator();

            while(itr.hasNext()){
                int a = itr.next();
                if(!visited[a]){
                    q.add(a);
                    visited[a] = true;
                }
            }
        }
    }
}

public class BFS{

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.edge(0, 1);
        g.edge(0, 2);
        g.edge(1, 2);
        g.edge(2, 0);
        g.edge(2, 3);
        g.edge(3, 3);

        g.bfs(2);
    }
}
