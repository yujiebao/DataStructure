package 并查集;

public class UnionFind2 implements UF {

    //孩子指向父亲
    private int[] parent;

    UnionFind2(int size)
    {
        parent = new int[size];

        for (int i = 0 ; i < size ; i++)
        {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p)
    {

        if (p < 0 || p > parent.length-1)
            throw new IllegalArgumentException("p is out of bound");

//        if (parent[p] == p)
//            return p;
//        return find(parent[p]);

        while (parent[p] != p )
            p = parent[p];
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;;

        parent[pRoot] = qRoot ;
    }
}
