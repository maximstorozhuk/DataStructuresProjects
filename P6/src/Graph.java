import java.util.List;

public class Graph {
	
	List<Edge> list;
	List<Node> nodeList;
	boolean isConnected(Node u, Node v, UnionFind uf) {
		return u.isConnected(v, uf);
	}
	
	Graph(List<Edge> L, List<Node> N){
		list = L;
		nodeList = N;
	}
	
	public void addEdge(int u, int v) {
		list.add(new Edge(u, v));
	}
}
