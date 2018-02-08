import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KruskalMST implements Comparator<Edge<Integer>>{

	@Override
	public int compare(Edge<Integer> edge1, Edge<Integer> edge2) {
		
		if(edge1.getWeight() <= edge2.getWeight())
			return -1;

		return 1;
	}


	public List<Edge<Integer>> findMST(Graph<Integer> g) {

		List<Edge<Integer>> edges = g.getAllEdges();

		Collections.sort(edges, this);

		DisjointSet ds = new DisjointSet();

		for(Vertex<Integer> v : g.getAllVertex()) {

			ds.makeSet(v.getId());
		}

		List<Edge<Integer>> res = new ArrayList<Edge<Integer>>();

		for(Edge<Integer> edge : edges) {

			long par1 = ds.findSet(edge.getVertex1().getId());
			long par2 = ds.findSet(edge.getVertex2().getId());

			if(par1 == par2) {

				continue;
			}

			res.add(edge);
			ds.union(edge.getVertex1().getId(), edge.getVertex2().getId());
		}

		return res;
	}

	public static void main(String[] args) {
		
		Graph<Integer> graph = new Graph<Integer>(false);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(2, 6, 3);
        graph.addEdge(2, 4, 2);
        graph.addEdge(6, 5, 2);
        graph.addEdge(6, 4, 3);
        graph.addEdge(4, 7, 2);
        graph.addEdge(3, 4, 5);
        graph.addEdge(3, 7, 8);

        KruskalMST mst = new KruskalMST();
        
        List<Edge<Integer>> result = mst.findMST(graph);
        
        for (Edge<Integer> edge : result) {
            System.out.println(edge.getVertex1() + " " + edge.getVertex2());
        }
	}
}
	
