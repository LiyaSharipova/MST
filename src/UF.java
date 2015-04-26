
public class UF {
	private int[] id;
	private int count;
	public UF(int N) {
		id=new int[N];
		count = N;
		for (int i = 0; i < N; i++) {
			id[i]=i;
		}
	}
	public int count() {
		return count;
	}
	public int find(int p) {
		return id[p];
	}
	public boolean connected(int p, int q) {
		return id[p]==id[q];
	}
	
	public void union(int p, int q) {
		int pID=find(p);
		int qID=find(q);
		//если p и q уже принадлежат одному компоненту
		if(pID==qID) return;
		//компонент p переименовывается в q
		for(int i=0; i<id.length; i++)
			if(id[i]==pID) id[i]=qID;
		count--;
	}
}
