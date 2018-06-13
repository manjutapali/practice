import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;

public class AlienDictionary {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		while(T-->0) {

			int N = in.nextInt();
			int k = in.nextInt();

			String[] d = new String[N];

			in.nextLine();
			
			for(int i = 0; i < N; i++) {
				d[i] = in.next();
			}

			PrintOrder(d, N, k);
		}
	}

	public static void PrintOrder(String s[], int N, int k) {

		Graph g = new Graph(k);

		for(int i = 0; i < N - 1; i++) {
			String w1 = s[i];
			String w2 = s[i+1];

			for(int j = 0; j < Math.min(w1.length(), w2.length()); j++) {

				if(w1.charAt(j) != w2.charAt(j)) {
					g.addEdge(w1.charAt(j) - 'a', w2.charAt(j) - 'a');
					break;
				}
			}
		}

		g.topologicalSort();
	}
}

class Graph {

	LinkedList<Integer>[] adj;

	public Graph(int v) {

		adj = new LinkedList[v];

		for(int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int v1, int v2) {

		adj[v1].add(v2);
	}

	public int getNumVertices() {
		return adj.length;
	}

	public void topologicalSort() {
		Stack<Integer> s = new Stack<Integer>();

		boolean v[] = new boolean[getNumVertices()];

		for(int i = 0; i < getNumVertices(); i++) {
			v[i] = false;
		}

		for(int i = 0; i < getNumVertices(); i++) {
			if(!v[i]) {
				topologicalSortUtil(i, v, s);
			}
		}

		while(!s.isEmpty()) {

			System.out.print((char)('a' + s.pop()) + " ");
		}

		System.out.println();
	}

	public void topologicalSortUtil(int vertex, boolean[] v, Stack<Integer> s) {

		v[vertex] = true;

		for(int adjVertex : adj[vertex]) {
			if(!v[adjVertex]) {
				topologicalSortUtil(adjVertex, v, s);
			}
		}

		s.push(vertex);
	}
}