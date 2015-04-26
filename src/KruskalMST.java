import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class KruskalMST {
	private LinkedList<Edge>  mst ;// все ребра МОД хранятся здесь
	public KruskalMST(WeightedGraph G){
		mst= new LinkedList<Edge>();
		PriorityQueue<Edge> pq= new PriorityQueue<Edge>(G.edges());//приоритетная очередь 
		// заполняется всеми ребрами и сортируется по возрастанию
		DisjointUnity uf= new DisjointUnity(G.V());//создаем непересек мн-ва
		//по кол-ву першин графа
		while(!pq.isEmpty()&& mst.size()<G.V()-1){//перебирает все ребра графа пр. очереди
			// пока она не опустеет и МОД не будет содержать N-1 ребер
			Edge e=pq.poll();//
			int v=e.either(), w=e.other(v);
			if(uf.connected(v, w)) continue;
			uf.union(v, w);
			mst.add(e);
		}
	}
	public Iterable<Edge> edges(){
		return mst;
	}

}
