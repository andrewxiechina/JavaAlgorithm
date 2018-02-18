package andrew.xie.algorithm.sort;

public class MaxPriorityQueue<Key> {
    private Key[] pq;
    private int n; //current populated size, remember pq starts with 1

    // Empty queue
    public MaxPriorityQueue(int capacity) {
        pq = (Key[]) new Object[capacity + 1];
        n = 0;
    }

    public MaxPriorityQueue(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[n + 1];

        for (int i = 0; i < n; i++) {
            pq[i+1] = keys[i];
        }

        for (int i = n/2; i >= 1; i--) {
            sink(i);
        }
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Key max() {
        return pq[1];
    }

    private void resize(int capacity) {
        assert capacity > n;
        Key[] tmp = (Key[]) new Object[capacity];
        for (int i = 0; i <= n; i++) {
            tmp[i] = pq[i];
        }
        pq = tmp;
    }

    public void insert(Key x) {
        if (n == pq.length - 1) resize(2 * pq.length);

        pq[++n] = x;
        swim(n);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;
        if((n > 0) && (n <= (pq.length-1)/4)) resize(pq.length/2);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(j, j+1)) j++; // Find the larger
            if (less(j, k)) break;
            exch(j, k);
            k = j;
        }
    }

    private boolean less (int i, int j) {
        return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private void printArray() {
        for (int i = 1; i <= n; i++) {
            System.out.print(pq[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 4, 3, 2, 1, 7, 9, 8, 10, 12, 25, 17, 19};
        MaxPriorityQueue<Integer> maxPQ = new MaxPriorityQueue<>(arr);
        maxPQ.insert(new Integer(15));

        while(!maxPQ.isEmpty())
            System.out.print(maxPQ.delMax() + " ");

    }
}
