public class TreeDisjointUnity {
	private int[] id;
    private int[] sz;
	private int count;

	public TreeDisjointUnity(int N) {
		id=new int[N];
		count = N;
        sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i]=i;
            sz[i]=1;
		}
	}

	public int count() {
		return count;
	}
	public int find(int p) {
		while (p!=id[p])
            p = id[p];
        return p;
	}

	public boolean connected(int p, int q) {
		return find(p)==find(q);
	}
	
	public void union(int p, int q) {

		int pID=find(p);
		int qID=find(q);
		if(pID==qID) return;//если p и q уже принадлежат одному компоненту

		//меньший корень должен указывать на больший
        if(sz[pID]<sz[qID]) {
            id[pID] = qID;
            sz[qID] += sz[pID];
        } else {
            id[qID] = pID;
            sz[pID] += sz[qID];
        }
		count--;
	}
}
