import java.util.*;
public class UnionFind {
	int[] parent;
	
	UnionFind(int size, List<Edge> edges){
		parent = new int[size];
		for(int i = 0; i < parent.length; i++) {
			parent[i] = i; //Initializes an array where the index = the value
		}
		for(int i = 0; i < edges.size(); i++) {
			this.union(edges.get(i).u, edges.get(i).v); //iterates over every edge given, calls union method
		}
	}
	
	public int find(int v) { //recursive method, returns the root. If the root is the same for two values, then they are connected
		if(parent[v] == v) {
			return v;
		}
		return find(parent[v]);
	}
	
	public void union(int u, int v) {
		if(u > v) { //ensures that u is alwayss less than or equal to v. This is useful so that the array is always increasing. This helped me fix the problem in the case of the two edges being 1-2 and 2-1
			int temp = u;
			u = v;
			v = temp;
		}
		int rootU = find(u); //using find(u) instead of just u ensures there will be no dead ends, and you are adding to the set
		int rootV = find(v); // same as above
		if(rootU != rootV) {
			parent[rootU] = rootV;
		}
	}
}
