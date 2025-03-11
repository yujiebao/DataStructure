package 线段树;

public class Main {
    public static void main(String[] args) {
        Integer[] num = {-2,0,3,-5,2,-1};
        SegmentTree<Integer> segTree = new SegmentTree<>(num,new Merger<Integer>(){
            @Override
            public Integer merge(Integer a, Integer b)
            {
                return  a+b;
            }
        });
        System.out.println(segTree);
        System.out.println(segTree.query(0,2));
    }
}
