
public class Node {
	int index;
	static int numNodes;
	
	/* A union find/disjoint set data structure is most appropriate for
	 * this problem. Given vertices and edges, having a union find
	 * algorithm results in the lowest time complexity. 
	 * There are varying time complexities for different steps
	 * The time complexity for initializing the UnionFind structure
	 * is O(n), with n being the number of edges passed into it
	 * This is because every edge needs to be iterated over so
	 * it can be unionized.
	 * However, that would be considered pre-processing time. By
	 * getting done with the operations that take more time, we are able
	 * to complete the union find itself in constant time. Technically,
	 * the worst case time complexity is O(log n), but the expected 
	 * time complexity will be O(1) for this.
	 */
	
	
	
	Node(int index){
		this.index = index;
		numNodes++;
	}
	boolean isConnected(Node v, UnionFind uf) {
		return uf.find(this.index) == uf.find(v.index);
	}
	
}
