public class FindUionUFExample {

    public static void main(String[] args) {
        FindUionUFExample uf = new FindUionUFExample(100);
        uf.union(1,40);
        uf.union(1, 35);
        System.out.println(uf.connected(40, 35));
    }
    private int[] arr;
    public FindUionUFExample(int N) {
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = i;
    }

    public int find(int node) { return arr[node]; }

    public void union(int p, int q) {
        int idp = arr[p];
        int idq = arr[q];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == idp) arr[i] = idq;
        }
    }

    public boolean connected(int p, int q) { return find(p) == find(q); }

    public int count() { return arr.length; }
}
