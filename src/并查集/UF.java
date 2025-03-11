package 并查集;

//union find
public interface UF {

    int getSize();

    boolean isConnected(int p,int q);

    void unionElements(int p,int q);

}
