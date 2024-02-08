import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

class GraphTest {

	static List<Edge> edges;
	static List<Node> nodes;
	
	@BeforeAll
	static void beforeAll() {
		edges = new ArrayList<>();
		Node.numNodes = 0;
		nodes = new ArrayList<>();
		nodes.add(0, new Node(0));
		nodes.add(1, new Node(1));
		nodes.add(2, new Node(2));
		nodes.add(3, new Node(3));
		nodes.add(4, new Node(4));
		nodes.add(5, new Node(5));
	}
	
	
	@Test
	void testIsConnected1() {
		edges.add(new Edge(1, 2));
		UnionFind uf1 = new UnionFind(Node.numNodes, edges);
		Graph g1 = new Graph(edges, nodes);
		assertTrue(g1.isConnected(nodes.get(1), nodes.get(2), uf1));
	}
	
	@Test
	void testIsConnected2() {
		edges = new ArrayList<>();
		edges.add(new Edge(1,2));
		edges.add(new Edge(2,3));
		UnionFind uf2 = new UnionFind(Node.numNodes, edges);
		Graph g2 = new Graph(edges, nodes);
		assertTrue(g2.isConnected(nodes.get(1), nodes.get(3), uf2));
	}
	
	@Test
	void testIsConnected3() {
		edges = new ArrayList<>();
		edges.add(new Edge(1, 2));
		edges.add(new Edge(3, 4));
		UnionFind uf3 = new UnionFind(Node.numNodes, edges);
		Graph g3 = new Graph(edges, nodes);
		assertFalse(g3.isConnected(nodes.get(1), nodes.get(3), uf3));
	}
	
	@Test
	void testIsConnected4() {
		edges = new ArrayList<>();
		edges.add(new Edge(1, 2));
		edges.add(new Edge(1, 3));
		UnionFind uf4 = new UnionFind(Node.numNodes, edges);
		Graph g4 = new Graph(edges, nodes);
		assertTrue(g4.isConnected(nodes.get(2), nodes.get(3), uf4));
	}
	
	@Test
	void testIsConnected5() {
		edges = new ArrayList<>();
		edges.add(new Edge(2, 1));
		edges.add(new Edge(1, 2));
		UnionFind uf5 = new UnionFind(Node.numNodes, edges);
		Graph g5 = new Graph(edges, nodes);
		assertTrue(g5.isConnected(nodes.get(1), nodes.get(2), uf5));
	}
	
	@Test
	void testIsConnected6() {
		edges = new ArrayList<>();
		edges.add(new Edge(1,2));
		UnionFind uf6 = new UnionFind(Node.numNodes, edges);
		Graph g6 = new Graph(edges, nodes);
		assertFalse(g6.isConnected(nodes.get(3), nodes.get(4), uf6));
	}
	
	@Test
	void testIsConnected7() {
		edges = new ArrayList<>();
		edges.add(new Edge(1,2));
		edges.add(new Edge(2,3));
		edges.add(new Edge(4,2));
		UnionFind uf7 = new UnionFind(Node.numNodes, edges);
		Graph g7 = new Graph(edges, nodes);
		assertTrue(g7.isConnected(nodes.get(1), nodes.get(4), uf7));
	}

}
