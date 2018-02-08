import java.util.HashMap;


class Node {

	long data;
	int rank;
	Node parent;
}

public class DisjointSet {

	private HashMap<Long, Node> map;

	public DisjointSet() {

		map = new HashMap<Long, Node>();
	}

	public void makeSet(long data) {

		Node p = new Node();

		p.data = data;
		p.rank = 0;
		p.parent = p;

		map.put(data, p);

	}

	public boolean union(long data1, long data2) {

		Node node1 = map.get(data1);
		Node node2 = map.get(data2);

		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);

		if(parent1.data == parent2.data)
		{
			return false;
		}

		if(parent1.rank >= parent2.rank)
		{
			parent1.rank = (parent1.rank == parent2.rank) ? (parent1.rank + 1) : parent1.rank;

			parent2.parent = parent1;
		}
		else {
			parent1.parent = parent2;
		}

		return true;
	}

	public long findSet(long data) {

		return findSet(map.get(data)).data;
	}

	private Node findSet(Node node) {
		Node parent = node.parent;

		if(node == parent)
			return parent;

		node.parent = findSet(parent);

		return node.parent;
	}


	public static void main(String args[]) {

		DisjointSet obj = new DisjointSet();

		obj.makeSet(1);
		obj.makeSet(2);
		obj.makeSet(3);
		obj.makeSet(4);
		obj.makeSet(5);
		obj.makeSet(6);
		obj.makeSet(7);

		obj.union(1,2);
		obj.union(2,3);
		obj.union(4,5);
		obj.union(6,7);
		obj.union(4,6);

		System.out.println(obj.findSet(2));
		System.out.println(obj.findSet(7));
		System.out.println(obj.findSet(4));
	}
}