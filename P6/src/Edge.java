
public class Edge {
	int u,v;
	
	Edge(int u, int v){
		this.u=u;this.v=v;
	}
	
	boolean isEqual(Edge e){
		return ( (e.u==u) & (e.v==v)) | ( (e.u==v) & (e.v==u));
	}
	
	public String toString() {
		return u + "-" + v;
	}
}
