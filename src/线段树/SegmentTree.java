package 线段树;


public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;
    public SegmentTree(E[] arr,Merger<E> merger)
    {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i  = 0 ; i < arr.length ; i++)
        {
            data[i] = arr[i];
        }

        tree =  (E[]) new Object[arr.length*4];
        buildSegmentTree(0,0,data.length-1);
    }

    //在树（Tree）的index位置创建表示区间[l....r]的线段树
    private void buildSegmentTree(int treeIndex, int l,int r)
    {
        if(l == r)
        {
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l+(r - l)/2;
        buildSegmentTree(leftTreeIndex,
                l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex] , tree[rightTreeIndex]);

    }

    public E query(int queryL,int queryR)
    {
        if (queryL < 0||queryL >data.length||queryR < 0||queryR >data.length||queryL>queryR)
            throw new IllegalArgumentException("Index illegal");

        return query(0,0,data.length-1,queryL,queryR);
    }

//    在以treeIndex为根的线段树[l.....r]的范围里，搜索[queryL,queryR]的值    l,r对应treeIndex树的区间
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {

        if (l == queryL && r == queryR)
            return tree[treeIndex];

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l+(r - l)/2;

        if (queryL >= mid+1)
            return query(rightTreeIndex,mid+1,r,queryL,queryR);
        else if(queryR <= mid)
            return query(leftTreeIndex,l,mid,queryL,queryR);

        E leftResult = query(leftTreeIndex,l,mid,queryL,mid);
        E rightResult = query(rightTreeIndex,mid + 1,r,mid+1,queryR);
        return merger.merge(leftResult,rightResult);

    }


    public E get(int index)
    {
        if (index < 0||index >= data.length)
            throw new IllegalArgumentException("Index is illegal");
        return data[index];
    }

    public int getSize()
    {
        return data.length;
    }

    public int leftChild(int i)
    {
        return 2*i+1;
    }

    public int rightChild(int i)
    {
        return 2*i+2;
    }


    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0;i < tree.length;i++)
        {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length-1)
                res.append(',');
        }
        res.append(']');
        return res.toString();
    }
}
