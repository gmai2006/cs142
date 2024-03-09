public class QuickUnionUF {

    public static void main(String[] args) {
        QuickUnionUF uf = new QuickUnionUF(100);
        uf.union(1,40);
        uf.union(1, 35);
        System.out.println(uf.connected(40, 35));
    }

    private int[] arr;
    public QuickUnionUF(int N) {
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = i;
    }

    public int find(int index) {
        while (index != arr[index]) index = arr[index];
        return index;
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        arr[pId] = qId;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

}
