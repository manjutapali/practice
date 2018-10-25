import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

public class TopologicalSort {
	public static void main(String[] args) {
		
		Graph<Integer> g = new Graph<Integer>(true);

		g.addEdge(1, 3);
		g.addEdge(1, 2);
		g.addEdge(3, 4);
		g.addEdge(5, 6);
		g.addEdge(6, 3);
		g.addEdge(3, 8);
		g.addEdge(8, 11);

		TopologicalSort t = new TopologicalSort();
		Stack<Vertex<Integer>> res = t.TopoSort(g);

		while(!res.isEmpty())
		{
			System.out.print(res.pop().getId() + " ");
		}

		System.out.println();
	}

	public Stack<Vertex<Integer>> TopoSort(Graph<Integer> g)
	{
		Stack<Vertex<Integer>> res = new Stack<Vertex<Integer>>();
		Set<Vertex<Integer>> vis = new HashSet<Vertex<Integer>>();

		for(Vertex<Integer> v : g.getAllVertex())
		{
			if(!vis.contains(v))
				TopoSortUtil(v, res, vis);
		}

		return res;
	}

	public void TopoSortUtil(Vertex<Integer> v, Stack<Vertex<Integer>> res, Set<Vertex<Integer>> vis)
	{
		vis.add(v);

		for(Vertex<Integer> c : v.getAdjacentVertexes())
		{
			if(!vis.contains(c))
				TopoSortUtil(c, res, vis);
		}

		res.push(v);
	}
}