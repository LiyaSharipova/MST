
public  class Edge implements Comparable<Edge> {
	private final int v;//одна вершина
	private final int w;//друга€
	private double weight;
	
	public Edge(int v, int w, double weight) {
		super();
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int either() {
		return v;
	}

	public double weight() {
		return weight;
	}
    public int other(int vertex) {
		if(vertex==v) return w;
		if(vertex==w) return v;
		else throw new RuntimeException("Ќедопустимое ребро");
	}


	@Override
	public int compareTo(Edge that) {
		if (this.weight()<that.weight()) return -1;
		if (this.weight()>that.weight()) return 1;
		 return 0;
		
	}
	public String toString(){
		return String.format("%d-%d %.2f", v, w, weight);
	}
//	public static void main(String[] args) {
//		System.out.println(new Edge(0, 1, 5.34244334).toString());
//	}

}
