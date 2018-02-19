// Trie is a three of alphabet table, a mothod try to outperform hash table
// Useful especially for natural languages
package andrew.xie.algorithm.string;

public class TrieST<Value> {
    private static final int R = 256;

    private Node root;
    private int n;

    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.value;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    public void put(String key, Value value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node x, String key, Value value, int d) {
        if (x == null) x = new Node();
        // If reach end of tree
        if (d == key.length()) {
            if (x.value == null) n++;
            x.value = value;
            return x;
        }

        // If not end of tree
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, value, d+1);
        return x;
    }

    public static void main(String[] args) {
        TrieST<Integer> st = new TrieST<>();

        st.put("AA", 1);
        st.put("BC", 2);
        st.put("CD", 3);
        st.put("D", 4);
        st.put("E", 5);

        System.out.println(st.get("CD"));

    }
}
