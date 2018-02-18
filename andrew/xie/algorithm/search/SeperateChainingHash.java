package andrew.xie.algorithm.search;

public class SeperateChainingHash<Key, Value> {
    private int n; // # keys
    private int m; // Hash table size
    private Sequential<Key, Value>[] st; // Linked-list Symbol Table

    SeperateChainingHash(int m) {
        this.m = m;
        st = (Sequential<Key, Value>[]) new Sequential[m];

        for (int i = 0; i < m; i++)
            st[i] = new Sequential<>();
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7ffffff) % m;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Value get(Key key) {
        int i = hash(key);
        return st[i].get(key);
    }

    public void put(Key key, Value value) {
        // Resize
        //if(n/m >= 10) resize(2*m);

        int i = hash(key);
        st[i].put(key, value);
    }

//    private void resize(int capacity) {
//        SeperateChainingHash<Key, Value> tmp = new SeperateChainingHash<>(capacity);
//        for (int i = 0; i < m; i++) {
//
//        }
//    }

    public static void main(String[] args) {
        SeperateChainingHash<String, Integer> s = new SeperateChainingHash(10);
        s.put("A", 1);
        s.put("B", 2);
        s.put("D", 5);
        s.put("C", 7);

        System.out.println(s.get("A"));


    }
}
