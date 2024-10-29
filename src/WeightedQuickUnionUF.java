public class WeightedQuickUnionUF {
    private final int[] arr;
    final int[] count;


    public static void main(String[] args) {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(100);
        uf.union(1,40);
        uf.union(1, 35);
        System.out.println(uf.connected(40, 35));
        System.out.println(uf.getCount(40) == 1);
        System.out.println(uf.getCount(35) == 1);
        System.out.println(uf.getCount(1) == 3);
    }

    public WeightedQuickUnionUF(int N) {
        arr = new int[N];
        count = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
            count[i] = 1;
        }
    }

    public int getCount(int index) { return count[index]; }

    public int find(int index) {
        while (index != arr[index]) index = arr[index];
        return index;
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;

        if (count[pId] < count[qId]) {
            arr[pId] = qId;
            count[qId] += count[pId];
        } else {
            arr[qId] = pId;
            count[pId] += count[qId];
        }

    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
